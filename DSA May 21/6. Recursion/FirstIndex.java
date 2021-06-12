
import java.io.*;
import java.util.*;

public class FirstIndex {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        
        System.out.println(firstIndex(arr,0,k));
    }

    public static int firstIndex(int[] arr, int idx, int k){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == k){
            // first occurance
            return idx;
        }
        
        int res = firstIndex(arr,idx+1,k);
        return res;
    }

}