import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(); /// declaration + memory creation
        
        System.out.println(queue);
        
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }
}
