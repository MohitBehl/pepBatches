import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];

        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = scn.nextInt();
        }

        System.out.println(span(arr));
    }

    public static int span(int arr[]) {
        // span of the array 

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        //   for(int idx = 0 ; idx < arr.length ; idx++){
        //       if(arr[idx] > max){
        //           max = arr[idx];
        //       }

        //       if(arr[idx] < min){
        //           min = arr[idx];
        //       }
        //   }

        for (int val: arr) {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        return max - min;
    }

}