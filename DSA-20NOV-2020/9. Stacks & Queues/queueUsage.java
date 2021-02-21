import java.util.*;

public class queueUsage {
    public static void main(String[] args) {
        //Queue interface : incomplete , implementation ArrayDeque
        Queue<Integer> queue = new ArrayDeque<>();

        System.out.println(queue+" size : "+queue.size());
        queue.add(10);
        System.out.println(queue+" size : "+queue.size());
        queue.add(20);
        System.out.println(queue+" size : "+queue.size());
        queue.add(30);
        System.out.println(queue+" size : "+queue.size());

        System.out.println(queue.peek());

        System.out.println("removed element : "+queue.remove() +" state : " + queue);
        System.out.println("removed element : "+queue.remove() +" state : " + queue);
        System.out.println("removed element : "+queue.remove() +" state : " + queue);

        System.out.println(queue.size());
    }
}
