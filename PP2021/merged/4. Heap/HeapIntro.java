import java.util.Collections;
import java.util.PriorityQueue;

public class HeapIntro{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        System.out.println(pq);

        pq.add(10);
        pq.add(20);
        pq.add(-1);
        pq.add(15);
        pq.add(-5);
        pq.add(16);
        pq.add(-10);

        System.out.println(pq);
        System.out.println(pq.peek());

        while(pq.size() > 0){
            System.out.println(pq.remove());
        }

    }
}