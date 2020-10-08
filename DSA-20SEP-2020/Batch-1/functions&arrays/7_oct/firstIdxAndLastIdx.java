import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt();

        System.out.println(firstOccurance(arr,ele));
        System.out.println(lastOccurance(arr,ele));
    }

    public static int firstOccurance(int arr[],int ele){
        int li = 0 ;
        int ri = arr.length-1;
        int fIdx = -1;
        while(li <= ri){
            int mid = (li + ri)/2;

            if(arr[mid] == ele){
                // potential first Index
                fIdx = mid;
                // move to left area in search better first Index
                ri = mid - 1;
            }else if(ele > arr[mid]){
                // larger area
                li = mid + 1;
            }else if(ele < arr[mid]){
                // smaller area --> left area
                ri = mid - 1;
            }
        }

        return fIdx;
    }

    public static int lastOccurance(int arr[],int ele){
        int li = 0 ;
        int ri = arr.length-1;
        int lIdx = -1;
        while(li <= ri){
            int mid = (li + ri)/2;

            if(arr[mid] == ele){
                // potential first Index
                lIdx = mid;
                // move to right area in search better last Index
                li = mid + 1;
            }else if(ele > arr[mid]){
                // larger area
                li = mid + 1;
            }else if(ele < arr[mid]){
                // smaller area --> left area
                ri = mid - 1;
            }
        }

        return lIdx;
    }

}