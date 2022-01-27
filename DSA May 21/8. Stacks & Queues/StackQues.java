import java.util.Stack;

public class StackQues {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        
        System.out.println(st);
        st.push(10);
        System.out.println(st);
        st.push(20);
        System.out.println(st);
        System.out.println(st.peek());
        System.out.println(st);
        st.push(30);
        System.out.println(st);
        st.push(40);
        System.out.println(st);
        System.out.println("pop:"+st.pop());
        System.out.println(st);
        st.push(50);
        System.out.println(st);
        System.out.println(st.size());
    }
}
