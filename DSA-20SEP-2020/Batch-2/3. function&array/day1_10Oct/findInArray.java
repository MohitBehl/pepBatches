import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt();

        int res = find(arr, ele);

        System.out.println(res);
    }

    public static int find(int arr[], int ele) {
        
        for(int i = 0 ; i < arr.length ;i++){
            int val = arr[i];
            if(val == ele){
                // element found @ i
                return i;
            }
        }
        
        // element was never found 
        return -1;
    }

}