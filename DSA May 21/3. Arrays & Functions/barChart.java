import java.io.*;
import java.util.*;

public class barChart{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = scn.nextInt();
    }
    
    int max = Integer.MIN_VALUE;
    
    for(int val : arr){
        if(val > max){
            max = val;
        }
    }
    
    for(int r = 0 ;r < max ; r++){
        for(int idx = 0 ;idx < arr.length ; idx++){
            if(r >= max-arr[idx]){
                System.out.print("*\t");
            }else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }
 }

}