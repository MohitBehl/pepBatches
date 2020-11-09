import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      
      int arr[] = new int[n];
      for(int i = 0 ; i < arr.length ; i++){
        arr[i] = scn.nextInt();
      }
      int tar = scn.nextInt();
      
      printTargetSumSubsets(arr,0,"",0,tar);
    }

    // set is the subset
    // ssf is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int ssf, int tar) {
        if(idx == arr.length){
            if(ssf == tar){
                System.out.println(set+".");
            }
            return;
        }
        if(ssf > tar){
            // tar can't be achieved through this branch
            return;
        }
        // include
        printTargetSumSubsets(arr,idx+1,set+arr[idx]+", ",ssf+arr[idx],tar);
        // not include
        printTargetSumSubsets(arr,idx+1,set,ssf,tar);
    }

}