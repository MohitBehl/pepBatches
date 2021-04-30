import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    
    int max = 0;
    int arr[] = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = scn.nextInt();
        
        if(arr[i] > max){
            max = arr[i];
        }
    }
    
    
    int nrow = max;
    int ncol = n;
    
    for(int row = nrow ; row >= 1 ; row--){
        for(int i = 0 ; i < ncol ; i++){
            if(arr[i] >= row){
                System.out.print("*\t");
            }else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }
 }

}