public class PQusage {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        System.out.println(pq);
        
        pq.add(10);
        // System.out.println(pq);
        
        pq.add(20);
        // System.out.println(pq);
        
        pq.add(-1);
        // System.out.println(pq);
        
        pq.add(69);
        // System.out.println(pq);
        
        pq.add(25);
        // System.out.println(pq);
        
        pq.add(30);
        // System.out.println(pq);
        
        pq.add(75);
        // System.out.println(pq);
        
        while(pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
