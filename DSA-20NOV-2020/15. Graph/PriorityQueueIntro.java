import java.util.PriorityQueue;
import java.util.Collections;
public class PriorityQueueIntro{
    public static class Sample implements Comparable<Sample>{
        int x , y;

        Sample(int x , int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "x : "+this.x+" y : "+this.y;
        }

        public int compareTo(Sample o){
            return o.y-this.y;
        }
        // this - o : min priority
        // o - this : max priority
    }
    public static void main(String args[]){
        PriorityQueue<Sample> pq1 = new PriorityQueue<>();

        pq1.add(new Sample(1,3));
        pq1.add(new Sample(3,4));
        pq1.add(new Sample(1,2));
        pq1.add(new Sample(2,5));
        pq1.add(new Sample(-1,100));
        pq1.add(new Sample(10,-3));

        while(pq1.size() > 0){
            System.out.println(pq1.remove());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(10);
        pq.add(-1);
        pq.add(100);
        pq.add(45);
        pq.add(96);
        pq.add(-200);
        pq.add(47);
        pq.add(-10);
        pq.add(-23);
        pq.add(25);
        pq.add(13);
        pq.add(1000);
        pq.add(19);

        while(pq.size() > 0){
            System.out.print(pq.remove()+" ");
        }

    }
}