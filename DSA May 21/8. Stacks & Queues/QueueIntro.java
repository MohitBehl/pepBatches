import java.util.ArrayDeque;
import java.util.Queue;

public class QueueIntro {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        System.out.println(queue);

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println(queue);

        System.out.println(queue.remove());

        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue.size());
    }
}
