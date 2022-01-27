import java.util.Scanner;

public class L001 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

        // System.out.println(isDuplicate(exp));
        boolean res = isBalanced(exp);
        System.out.println(res);
    }

    public static boolean isDuplicate(String exp){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i < exp.length() ; i++){
            char ch = exp.charAt(i);
            
            if(ch == ')'){
                if(st.peek() == '('){
                    return true;
                }
                
                while(st.peek() != '('){
                    st.pop();
                }
        
                st.pop(); // for opening bracket
            }else{
                st.push(ch);
            }
        }
        
        return false;
    }

    public static boolean isBalanced(String exp){
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < exp.length() ; i++){
            char ch = exp.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                st.push(ch);
            }else if(ch == ')' || ch == '}' || ch == ']'){
                if(st.size() == 0){
                    // nCB > nOB
                    return false;
                }
                if(ch == ')' && st.peek() != '('){
                    return false;
                }
                if(ch == '}' && st.peek() != '{'){
                    return false;
                }
                if(ch == ']' && st.peek() != '['){
                    return false;
                }
                st.pop();
            }
        }
        if(st.size() > 0){
            // nOB > nCB
            return false;
        }
        return true;
    }

    public static int[] NGER(int[] arr){
        int res[] = new int[arr.length];
        
        Stack<Integer> st = new Stack<>();
        res[arr.length-1] = -1;
        st.push(arr[arr.length-1]);
        
        for(int i = arr.length-2 ; i>= 0 ; i--){
            while(st.size() > 0 && arr[i] > st.peek()){
                st.pop();
            }
            
            if(st.size() == 0){
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }
           
            st.push(arr[i]);
        }
        return res;
      }
}
