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
      
      for(int idx = 0 ; idx < arr.length ; idx++){
          if(pq.size() < k){
              pq.add(arr[idx]);
          }else if(pq.size() == k){
              int minPq = pq.peek();
              if(minPq < arr[idx]){
                  pq.remove();
                  pq.add(arr[idx]);
              }
          }
      }
      
      while(pq.size() > 0){
          System.out.println(pq.remove());
      }
    }

}