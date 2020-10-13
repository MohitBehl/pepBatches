import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[n] = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = scn.nextInt();
    }
    int ele = scn.nextInt();

    System.out.println(firstOccur(arr,ele));
    System.out.println(lastOccur(arr,ele));
 }

 public static int firstOccur(int arr[],int ele){
     int li = 0 , ri = arr.length-1 , fo = -1;

     while(li <= ri){
         int mid = (li + ri)/2;

         if(arr[mid] == ele){
            // potential first occur.
            fo = mid;
            // move to left area --> smaller area
            ri = mid -1;
         }else if(ele > arr[mid]){
            li = mid + 1;
         }else if(ele < arr[mid]){
            li = mid - 1;
         }
     }

     return fo;
 }
 public static int lastOccur(int arr[],int ele){
    int li = 0 , ri = arr.length-1 , lo = -1;

    while(li <= ri){
        int mid = (li + ri)/2;

        if(arr[mid] == ele){
           // potential last occur.
           lo = mid;
           // move to right area --> larger area
           li = mid + 1; 
        }else if(ele > arr[mid]){
           li = mid + 1;
        }else if(ele < arr[mid]){
           li = mid - 1;
        }
    }

    return lo;
}
}