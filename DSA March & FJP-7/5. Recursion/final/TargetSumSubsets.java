import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        printTargetSumSubsets(arr,0,"",0,tar);
    }
    public static void printTargetSumSubsets(int[] arr, int idx, String asf, int sum, int tar) {
        if(sum > tar){return;}
        if(idx == arr.length){
            if(sum == tar){
                System.out.println(asf+".");
            }
            return;
        }
        
        printTargetSumSubsets(arr,idx+1,asf+arr[idx]+", ",sum+arr[idx],tar);
        printTargetSumSubsets(arr,idx+1,asf,sum,tar);
    }

}