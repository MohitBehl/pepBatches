import java.io.*;
import java.util.*;

public class span{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = scn.nextInt();
    }
    
    int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
    
    
    for(int i = 0 ; i < n ; i++){
        if(arr[i] > max){
            max = arr[i];
        }
        
        if(arr[i] < min){
            min = arr[i];
        }
    }
    
    System.out.println(max-min);
 }

}