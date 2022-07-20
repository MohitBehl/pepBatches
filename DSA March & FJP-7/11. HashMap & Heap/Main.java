import java.util.*;
public class Main{
    
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        System.out.println(pq+" size : "+pq.size());
        pq.add(10);
        System.out.println(pq+" size : "+pq.size());
        pq.add(1);
        System.out.println(pq+" size : "+pq.size());
        pq.add(-1);
        System.out.println(pq+" size : "+pq.size());
        pq.add(3);
        System.out.println(pq+" size : "+pq.size());
        pq.add(5);
        System.out.println(pq+" size : "+pq.size());
        pq.add(4);
        System.out.println(pq+" size : "+pq.size());


        System.out.println(pq.peek());
        // while(pq.size() > 0){
        //     System.out.println(pq.remove());
        // }
    }
}