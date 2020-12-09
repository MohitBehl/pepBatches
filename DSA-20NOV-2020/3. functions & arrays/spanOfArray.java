import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[]= new int[n];
        
        for(int idx = 0 ; idx < n ; idx++){
            arr[idx] = scn.nextInt();
        }
        
        // logic for span of array.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int idx = 0 ; idx < arr.length ; idx++){
            int val = arr[idx];
            
            if(val < min){
                min = val;
            }
            
            if(val > max){
                max = val;
            }
        }
        
        System.out.println(max-min);
    }

}