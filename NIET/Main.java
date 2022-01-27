import java.util.*;
public class Main{
    public static class Sample implements Comparable<Sample>{
        int x , y;

        Sample(int x,int y){
            this.x = x;
            this.y = y;
        }

        // this - o : min
        // o - this : max
        public int compareTo(Sample o){
            return o.x-this.x;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Sample> pq = new PriorityQueue<>();
        pq.add(new Sample(10,-5));
        pq.add(new Sample(-9,55));
        pq.add(new Sample(100,-1));
        pq.add(new Sample(190,-52));

        while(pq.size() > 0){
            Sample obj = pq.remove();
            System.out.println("x : "+obj.x+" y : "+obj.y);
        }
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // System.out.println(pq);

        // pq.add(10);
        // // System.out.println(pq);
        // pq.add(20);
        // // System.out.println(pq);
        // pq.add(-2);
        // // System.out.println(pq);
        // pq.add(-5);
        // // System.out.println(pq);
        // pq.add(11);
        // // System.out.println(pq);
        // pq.add(16);
        // // System.out.println(pq);

        // while(pq.size() > 0){
        //     System.out.print(pq.remove()+"  ");
        // }
        // System.out.println(".");
    }
}