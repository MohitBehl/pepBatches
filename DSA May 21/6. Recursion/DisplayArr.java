
import java.io.*;
import java.util.*;

public class DisplayArr {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        
        // displayArr1(arr,0);
        displayArr2(arr,arr.length-1);
    }

    public static void displayArr1(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr1(arr,idx+1);
    }
    
    public static void displayArr2(int arr[] ,int idx){
        if(idx == -1){
            return;
        }
        displayArr2(arr,idx-1);
        System.out.println(arr[idx]);
    }

}