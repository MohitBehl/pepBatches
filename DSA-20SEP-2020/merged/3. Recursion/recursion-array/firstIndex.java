import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt();
        
        int fi = firstIndex(arr,0,ele);
        System.out.println(fi);
    }

    public static int firstIndex(int[] arr, int idx, int ele){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == ele){
            return idx;
        }
        int rres = firstIndex(arr,idx+1,ele);
        return rres;
    }

}