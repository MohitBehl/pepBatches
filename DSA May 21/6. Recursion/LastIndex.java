import java.io.*;
import java.util.*;

public class LastIndex {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int res = lastIndex(arr,0,k);
        System.out.println(res);
    }

    public static int lastIndex(int[] arr, int idx, int k){
        if(idx == arr.length){
            return -1;
        }
        int li = lastIndex(arr,idx+1,k);
        
        if(li == -1){
            if(arr[idx] == k){
                return idx;
            }else{
                return -1;
            }
        }else{
            return li;
        }
    }

}