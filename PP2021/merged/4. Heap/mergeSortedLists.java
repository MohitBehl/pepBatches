import java.io.*;
import java.util.*;

public class Main {
   public static class Pair implements Comparable<Pair>{
       int li , di , val;
       Pair(int li , int di , int val){
           this.li = li;
           this.di = di;
           this.val = val;
       }
       // this-o : min priority
       // o-this : max priority
      public int compareTo(Pair o){
          // -ve , +ve , 0
          return this.val-o.val; // min on the basis of val
      }
   } 
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<Pair> pq = new PriorityQueue<>();
      
      for(int idx = 0 ; idx < lists.size() ; idx++){
          pq.add(new Pair(idx,0,lists.get(idx).get(0)));
      }
      
      while(pq.size() > 0){
          Pair minPair = pq.remove();
          
          rv.add(minPair.val);
          
          if(minPair.di+1 < lists.get(minPair.li).size()){
              minPair.di = minPair.di+1;
              minPair.val = lists.get(minPair.li).get(minPair.di);
              pq.add(minPair);
          }
      }
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}