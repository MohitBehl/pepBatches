import java.io.*;
import java.util.*;

public class DisplayArrReverse {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        
        // displayArrReverse(arr,0);
        displayArrReverse1(arr,arr.length-1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx == arr.length){
            return;
        }
        displayArrReverse(arr,idx+1);
        System.out.println(arr[idx]);
    }
    
    public static void displayArrReverse1(int[] arr, int idx) {
        if(idx == -1){
            return;
        }
        System.out.println(arr[idx]);
        displayArrReverse1(arr,idx-1);
    }

}