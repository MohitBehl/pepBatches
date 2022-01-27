import java.io.*;
import java.util.*;

public class Main {

  public static void CountSort(int[] arr, int min, int max) {
   
   int numOfUnique = max-min+1;
   int freq[] = new int[numOfUnique];
   
   for(int val : arr){
       freq[val-min]++;
   }
   
   for(int idx = 1 ; idx < numOfUnique ; idx++){
       freq[idx] = freq[idx] + freq[idx-1];
   }
   
   int res[] = new int[arr.length];
   
   for(int idx = arr.length-1 ; idx >= 0 ; idx--){
       int val = arr[idx];
       int pos = val - min;
       int place = freq[pos];
       res[place-1] = val;
       freq[pos]--;
   }
   
   for(int i = 0 ; i < arr.length ; i++){
       arr[i] = res[i];
   }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}