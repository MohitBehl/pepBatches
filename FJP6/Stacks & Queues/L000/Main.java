import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void stackIntro(){
        Stack<Integer> st = new Stack<Integer>();
        System.out.println(st);

        st.push(10);
        System.out.println(st.size()+" : "+st);
        st.push(20);
        System.out.println(st.size()+" : "+st);
        st.push(30);
        System.out.println(st.size()+" : "+st);
        st.push(40);
        System.out.println(st.size()+" : "+st);

        for(int ele : st){
            System.out.print(ele +" -> ");
        }
        System.out.println();

        System.out.println(st.pop()+" - "+st);
        System.out.println(st.peek() +" - "+st);
    }

    public static void queueIntro(){
        Queue<Integer> queue = new ArrayDeque<>();

        System.out.println(queue.size() +" "+ queue);
        queue.add(10);
        System.out.println(queue.size() +" "+ queue);
        queue.add(20);
        System.out.println(queue.size() +" "+ queue);
        queue.add(30);
        System.out.println(queue.size() +" "+ queue);
        queue.add(40);
        System.out.println(queue.size() +" "+ queue);
        queue.add(50);
        System.out.println(queue.size() +" "+ queue);
        System.out.println(queue.remove()+" <-> "+queue.size() +" "+ queue);
        System.out.println(queue.remove()+" <-> "+queue.size() +" "+ queue);
        System.out.println(queue.peek()+" <-> "+queue.size() +" "+ queue);

        for(int ele : queue){
            System.out.print(ele+" -> ");
        }
        System.out.println(".");
    }
    public static void main(String[] args) {
        // stackIntro();
        queueIntro();
    }
}
