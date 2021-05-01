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
    
    brokenEconomy(arr,k);
 }
 
 public static void brokenEconomy(int arr[],int k){
     int ceil = -1 , floor = -1;
     int lo = 0 , hi = arr.length-1;
     
     while(lo <= hi){
         int mid = (lo + hi)/2;
         
         if(k == arr[mid]){
             ceil = floor = arr[mid];
             break;
         }else if(k < arr[mid]){
             hi = mid-1;
             ceil = arr[mid];
         }else if(k > arr[mid]){
             lo = mid+1;
             floor = arr[mid];
         }
     }
     System.out.println(ceil+"\n"+floor);
 }

}