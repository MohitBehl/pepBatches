import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int size = scn.nextInt();

        int arr[] = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = scn.nextInt();
        }

        // span of array
        spanOfArray(arr);
    }
    public static int spanOfArray(int arr[]){

        int max  = Integer.MIN_VALUE; 
        int min  = Integer.MAX_VALUE;

        for(int idx = 0 ; idx < arr.length ; idx++){
            int val = arr[idx];

            if(val < min){
                min = val;
            }
            if(val > max){
                max = val;
            }
        }

        return (max-min);
    }
}