import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Day1 {
    public static boolean duplicateBrackets(String exp){
        Stack<Character> st = new Stack<>();

        for(int idx = 0 ; idx < exp.length() ; idx++){
            char ch = exp.charAt(idx);
            Arrays.sort(a);

            if(ch == ')'){
                int count = 0;

                while(st.peek() != '('){
                    st.pop();
                    count++;
                }

                st.pop();

                if(count == 0){
                    // duplicacy of brackets found
                    return true;
                }
            }else{
                st.push(ch);
            }
        }
        return false;

    }

    public static boolean isExpBalanced(String str) {
        Stack < Character > st = new Stack < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (st.size() == 0) {
                    // number of closing braces are more than opening.
                    return false;
                }

                if (ch == ')') {
                    if (st.peek() != '(')
                        return false;
                    else
                        st.pop();
                }

                if (ch == '}') {
                    if (st.peek() != '{')
                        return false;
                    else
                        st.pop();
                }

                if (ch == ']' ) {
                    if (st.peek() != '[')
                        return false;
                    else
                        st.pop();
                }
            }
        }
        if (st.size() != 0) {
            // number of opening braces are more than closing.
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);

        // String str = scn.nextLine();

        // // System.out.println(duplicateBrackets(str));
        // System.out.println(isExpBalanced(str));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nextGreaterEleOnRight = solve(a);
        display(nextGreaterEleOnRight);
    }


    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }


    public static int[] nextGreaterEleOnRight(int[] arr) {
        int n = arr.length;
        Stack < Integer > st = new Stack < > ();
        int nge[] = new int[n];
        nge[n - 1] = -1;
        st.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            int val = arr[i];

            while (st.size() > 0 && val >= st.peek()) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(val);
        }
        return nge;
    }

}
