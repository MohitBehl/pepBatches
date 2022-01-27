import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
    public static class Person implements Comparable<Person>{
        int wt,marks,rank;

        Person(int wt,int marks,int rank){
            this.wt = wt;
            this.marks = marks;
            this.rank = rank;
        }

        public String toString(){
            return "WT : "+this.wt+"\t Marks : "+this.marks+"\t Rank : "+this.rank;
        }
        
        // compareTo : +ve , -ve , 0
        // min : this - o
        // max : o - this
        public int compareTo(Person o){
            return o.rank-this.rank;
        }
    }
    public static void main(String[] args) {

        PriorityQueue<Person> pq = new PriorityQueue<>();
        
        pq.add(new Person(10,-95,3));
        pq.add(new Person(5,99,1));
        pq.add(new Person(15,0,25));
        pq.add(new Person(6,-32,12));
        pq.add(new Person(3,51,10));
        pq.add(new Person(20,-40,11));

        // System.out.println(pq.peek());
        while(pq.size() > 0){
            System.out.println(pq.remove());
        }

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // // System.out.println(pq);
        // pq.add(10);
        // // System.out.println(pq);
        // pq.add(-1);
        // // System.out.println(pq);
        // pq.add(5);
        // // System.out.println(pq);
        // pq.add(8);
        // // System.out.println(pq);
        // pq.add(13);
        // // System.out.println(pq);
        // pq.add(0);
        // // System.out.println(pq);
        // pq.add(10);
        // System.out.println(pq);

        // // peek : highest priority element 
        // System.out.println(pq.peek());

        // System.out.println("Size "  + pq.size());

        // while(pq.size() > 0){
        //     System.out.println(pq.remove());
        // }
    }

    public static void KlargestElements() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
  
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < k ; i++){
            pq.add(arr[i]);
        }
        
        for(int i = k ; i< n ; i++){
            if(arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        
        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
     }

     public static void sortksortedList() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
  
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int k = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i <= k ; i++){
          pq.add(arr[i]);    
        }
        
        for(int i = k+1 ; i < n ;i++){
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        
        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
     }

     public static class Pair implements Comparable<Pair>{
        int li,vi,val;
        Pair(int li,int vi,int val){
            this.li = li;
            this.vi = vi;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
      ArrayList<Integer> rv = new ArrayList<>();
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      
      for(int i = 0 ; i < lists.size() ; i++){
          pq.add(new Pair(i,0, lists.get(i).get(0) ));
      }
      
      while(pq.size() > 0){
          Pair tmp = pq.remove();
          
          rv.add(tmp.val);
          
          if(tmp.vi+1 < lists.get(tmp.li).size() ){
              tmp.vi = tmp.vi+1;
              tmp.val = lists.get(tmp.li).get(tmp.vi);
              pq.add(tmp);
          }
      }
  
      return rv;
    }
}
