import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] a, int k){
    // write your code here
    
    // true rotation number
    k = k % a.length;
    
    // -ve case 
    if(k < 0){
        k = k + a.length;
    }
    
    // a = part1 + part2
    // 1. reverse last k elements --> reverse part2
    reverse(a, a.length-k , a.length-1 );
    // 2. reverse first n-k elements --> reverse part1
    reverse(a, 0 , a.length-k-1 );
    // 3. reverse all n elements
    reverse(a,0,a.length-1 );
  }
  public static void reverse(int a[],int li,int ri){
      while(li < ri){
          int temp = a[li];
          a[li] = a[ri];
          a[ri] = temp;
          
          li++;
          ri--;
      }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    
    for(int i = 0 ; i < a.length ; i++){
        System.out.print(a[i]+" ");
    }
    
    // display(a);
 }

}