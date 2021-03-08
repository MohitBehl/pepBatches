import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        String exp = scn.nextLine();
        
        System.out.println(isDuplicate(exp));
        
    }
    
    public static boolean isDuplicate(String exp){
        Stack<Character> st = new Stack<>();
        
        for(int idx = 0 ; idx < exp.length() ; idx++){
            char ch = exp.charAt(idx);
            if(ch == ')'){
                if(st.peek() == '('){
                    return true; // duplicacy detected
                }else{
                    // valid bracket
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        
        return false; //  implication duplicacy was never detected i.e. exp has no duplicate brackets
    }

}