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
        
        int li = lastIndex(arr,0,ele);
        System.out.println(li);
    }

    public static int lastIndex(int[] arr, int idx, int ele){
        if(idx == arr.length){
            return -1; // last occurance is yet to be found
        }
        int rres = lastIndex(arr,idx+1,ele);
        
        if(rres == -1){
            if(arr[idx] == ele){
                // lastOccurance
                return idx;
            }
        }
        
        return rres;
    }

}