import java.util.Queue;
import java.util.ArrayDeque;

public class queueIntro {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue);

        queue.add(10);
        System.out.println("add 10 : "+"-->"+queue);

        queue.add(20);
        System.out.println("add 20 : "+"-->"+queue);

        queue.add(30);
        System.out.println("add 30 : "+"-->"+queue);

        System.out.println("rem : "+queue.remove());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.size());
    }   
}
