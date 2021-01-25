import java.util.*;

public class Main {


    public static void main(String[] args) {

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // System.out.println(pq);

        // pq.add(10);
        // // System.out.println(pq);
        // pq.add(20);
        // // System.out.println(pq);
        // pq.add(-1);
        // // System.out.println(pq);
        // pq.add(5);
        // // System.out.println(pq);
        // pq.add(8);
        // // System.out.println(pq);
        // pq.add(30);
        // // System.out.println(pq);
        // pq.add(-10);
        // // System.out.println(pq);

        // while(pq.size() > 0){
        //     System.out.println(pq.remove());
        // }
        PriorityQueue < Pair > pq = new PriorityQueue < > ();

        pq.add(new Pair("alex", 80, 3));
        pq.add(new Pair("sam", 0, 20));
        pq.add(new Pair("max", 90, 2));
        pq.add(new Pair("ben", 50, 10));
        pq.add(new Pair("scooby", 75, 5));

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
    public static class Pair implements Comparable < Pair > {
        String name;
        int marks;
        int rank;

        Pair(String name, int marks, int rank) {
            this.name = name;
            this.marks = marks;
            this.rank = rank;
        }
        // this - o : min
        // o - this : max
        public int compareTo(Pair o) {
            return o.rank - this.rank;
        }

        public String toString() {
            return ("name:" + this.name + "\tmarks :" + this.marks + "\trank:" + this.rank);
        }
    }
}