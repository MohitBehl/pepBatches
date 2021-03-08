import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
    int n = arr.length;
   int nger[] = new int[n];
   nger[n-1] = -1;
   Stack<Integer> st = new Stack<>();
   st.push(arr[n-1]);
   
   for(int idx = n-2 ; idx >= 0 ; idx--){
       int val = arr[idx];
       while(st.size() > 0 && st.peek() <= val){
           st.pop();
       }
       
       if(st.size() == 0){
           nger[idx] = -1;
       }else{
           nger[idx] = st.peek();
       }
       
       st.push(val);
   }
   
   return nger;
 }

}