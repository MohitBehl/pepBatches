import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        int res = MSNAE(arr,0,false);
        System.out.println(res);
    }
    // flag = true ; previous element was included
    // flag = false ; previous element was not included
    public static int MSNAE(int arr[],int idx,boolean flag){
        if(idx == arr.length){
            return 0;
        }
        int ele = arr[idx];
        int inc = 0;
        if(flag == false){
            inc = MSNAE(arr,idx+1,true)+ele;// inc
        }
        // exc
        int exc = MSNAE(arr,idx+1,false);

        int ans = Math.max(inc,exc);
        return ans;
    }
}