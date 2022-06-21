import java.util.Stack;
public class Main{
    public static void stackIntro(){
        Stack<Integer> st = new Stack<>();
        System.out.println(st+" -> size : "+st.size());

        st.push(10);
        System.out.println("TME : "+st.peek());
        st.push(20);
        System.out.println("TME : "+st.peek());
        st.push(30);
        System.out.println("TME : "+st.peek());
        System.out.println(st+" -> size : "+st.size());
        System.out.println("TME : "+st.peek());
        System.out.println("removed ele : "+st.pop() +" status :"+st);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70);
        System.out.println(st);

        for(int ele : st){
            System.out.print(ele +" -> ");
        }
        System.out.println();
    }
    public static boolean duplicateBrackets(String exp){
        Stack<Character> st = new Stack<>();

        for(int idx = 0 ; idx < exp.length() ; idx++){
            char ch = exp.charAt();

            if(ch == ')'){
                if(st.peek() == '('){
                    return true; // found an extra set of brackets
                }else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop(); // for opening bracket
                }
            }else if(ch == ' '){
                continue;
            }else {
                st.push(ch);
            }
        }

        return false;
    }

    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos+1;
        }

        void display() {
            for(int idx =  tos ; idx >= 0 ; idx--){
                System.out.print(data[idx]+" ");
            }
            System.out.println();
        }

        void push(int val) {
            if(size() == data.length){
                System.out.println("Stack overflow");
                return;
            }
            tos++;
            data[tos] = val;
        }

        int pop() {
            if(size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            int vl = data[tos];
            tos--;
            return vl;
        }

        int top() {
            if(size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            int vl = data[tos];
            return vl;
        }
    }
    public static void main(String args[]){
        CustomStack st = new CustomStack(5);
        // stackIntro();
        // Scanner scn = new Scanner(System.in);
        // String exp = scn.nextLine();
        // System.out.println(duplicateBrackets(exp));
    }
}