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
    // true rotations
    k = k % a.length; // rotations --> in range
    
    // k : -ve --> +ve
    if(k < 0){
        k = k + a.length;
    }
    
    // a[] = p1 + p2
    // 1. reverse part 2
    reverse(a,a.length-k,a.length-1);
    // 2. reverse part 1
    reverse(a,0,a.length-k-1);
    // 3. reverse complete array
    reverse(a,0,a.length-1);
  }
  
  public static void reverse(int a[],int st,int ed){
      while(st < ed){
          int temp = a[st];
          a[st] = a[ed];
          a[ed] = temp;
          
          st++;
          ed--;
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
    display(a);
 }

}