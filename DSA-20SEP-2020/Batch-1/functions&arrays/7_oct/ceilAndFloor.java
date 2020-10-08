import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();


        int ceil = Integer.MAX_VALUE, floor = Integer.MIN_VALUE;
        int li = 0 , ri = arr.length-1;
        while(li <= ri){
            int mid = (li+ri)/2;

            if(arr[mid] == k){
                ceil = k; 
                floor = k;
                break;
            }else if(k > arr[mid]){
                // larger area
                li = mid + 1;
                floor = arr[mid];
            }else if(k < arr[mid]){
                // smaller area
                ri = mid - 1;
                ceil = arr[mid];
            }
        }

        System.out.println(ceil);
        System.out.println(floor);
    }

}