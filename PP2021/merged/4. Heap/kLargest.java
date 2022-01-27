import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      for(int val : arr){
          if(pq.size() < k){
              pq.add(val);
          }else{
              int min = pq.peek();
              if(min < val){
                  // new value is better than smallest value in priority Queue
                  pq.remove(); //  smallest element removed
                  pq.add(val);
              }
          }
      }
      
      while(pq.size() > 0){
          System.out.println(pq.remove());
      }
    }

}