import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        System.out.println(isBalanced(exp));
    }
    
    public static boolean isBalanced(String exp){
        Stack<Character> st = new Stack<>();
        
        for(int idx = 0 ; idx < exp.length() ; idx++){
            char ch = exp.charAt(idx);
            
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }else if(ch == '}' || ch == ')' || ch == ']'){
                if(st.size() == 0){
                    // n(Closing bracket) > n(opening bracket)
                    return false;
                }
                
                if( (ch == ')' && st.peek() != '(') 
                || (ch == '}' && st.peek() != '{') 
                || (ch==']' && st.peek() != '[') ){
                    // bracket mismatched
                    return false;
                }else{
                    st.pop(); // valid opening bracket
                }
            }
        }
        if(st.size() > 0){
            // n(Closing bracket) < n(opening bracket)
            return false;
        }
        return true;
    }

}