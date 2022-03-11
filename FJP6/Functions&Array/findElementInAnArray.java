import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // len 
        int arr[] = new int[n]; // arr
        for(int idx = 0 ; idx <= n-1 ; idx++){
            arr[idx] = scn.nextInt();
        }
        int ele = scn.nextInt(); // element

        int res = find(arr,ele);
        System.out.println(res);
    }
    public static int find(int arr[],int ele){
        for(int idx = 0 ; idx <= arr.length-1 ; idx++){
            if(arr[idx] == ele){
                return idx; // element found
            }
        }
        return -1; // element not found
    }

}