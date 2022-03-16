import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        binarySearch(arr,k);
    }
    public static void binarySearch(int[] arr,int k){
        int lo = 0 , hi = arr.length-1;

        int ceil = 0 , floor = 0;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(k < arr[mid]){ // left,ceil
                hi = mid-1;
                ceil = arr[mid];
            }else if(k > arr[mid]){ // right,floor
                lo = mid+1;
                floor = arr[mid];
            }else{ // element found
                // System.out.println(arr[mid]);
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }

        System.out.println(ceil);
        System.out.println(floor);
    }

}