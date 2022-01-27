import java.io.*;
import java.util.*;

public class MaxOfAnArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        
        System.out.println(maxOfArray(arr,arr.length-1));
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == -1){
            return Integer.MIN_VALUE;
        }
        int vl = maxOfArray(arr,idx-1);
        if(arr[idx] > vl){
            return arr[idx];
        }else{
            return vl;
        }
        
    }

}