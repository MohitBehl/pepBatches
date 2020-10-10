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
        
        System.out.println(span(arr));
    }
    
    public static int span(int arr[]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int idx = 0 ; idx < arr.length ; idx++){
            if(arr[idx] > max){
                max = arr[idx];
            }
            
            if(arr[idx] < min){
                min = arr[idx];
            }
        }
        return (max-min);
    }

}