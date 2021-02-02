import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        
        for(int idx = 0 ; idx < arr.length ;idx++){
            arr[idx] = scn.nextInt();
        }
        
        int x = scn.nextInt();
        
        System.out.println(firstIdx(arr,x));
        System.out.println(lastIdx(arr,x));
        // firstAndLastIndex(arr,x);
    }
    public static int firstIdx(int arr[],int x){
        int lo = 0 , hi = arr.length-1 , fi = -1;
        
        while(lo <= hi){
            int mid = (lo+hi)/2;
            
            if(arr[mid] == x){
                fi = mid;
                
                hi = mid-1;
            }else if(x > arr[mid]){
                // larger
                lo = mid+1;
            }else if(x < arr[mid]){
                // smaller
                hi = mid-1;
            }
        }
        return fi;
    }
    public static int lastIdx(int arr[],int x){
        int lo = 0 , hi = arr.length-1 , li = -1;
        
        while(lo <= hi){
            int mid = (lo+hi)/2;
            
            if(arr[mid] == x){
                li = mid;
                lo = mid+1;
            }else if(x > arr[mid]){
                // larger
                lo = mid+1;
            }else if(x < arr[mid]){
                // smaller
                hi = mid-1;
            }
        }
        return li;
    }
    public static void firstAndLastIndex(int arr[],int x){
        int firstIdx = -1;
        int lastIdx = -1;
        
        for(int idx = 0 ; idx < arr.length ; idx++){
            if(arr[idx] == x){
                if(firstIdx == -1){
                    firstIdx = idx;
                }
                
                lastIdx = idx;
            }
        }
        System.out.println(firstIdx+"\n"+lastIdx);
    }
}