import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt(); // to find : LAST occurance of ele in arr.

        System.out.println(lastIndex(arr, 0, ele));
    }

    public static int lastIndex(int[] arr, int idx, int ele){
        if(idx == arr.length){
            return -1;
        }
        
        int rres = lastIndex(arr,idx+1,ele);
        
        if(rres == -1){
            // last occur hasn't happened till now 
            if(arr[idx] == ele){
                // element found --> idx is last occur
                rres = idx;
            }
        }
        
        return rres;
    }

}