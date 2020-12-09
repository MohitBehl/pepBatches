import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        
        int x = scn.nextInt(); // find element x in arr
        
        System.out.println(find(arr,x));
    }
    
    public static int find(int arr[],int x){
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == x){
                // element found
                return i;
            }
        }
        
        // indirect implication : element not found
        return -1;
    }

}