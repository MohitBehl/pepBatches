import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);

        int size = scn.nextInt();

        int arr[] = new int[size];

        for(int idx = 0 ; idx < arr.length ; idx++){
            arr[idx] = scn.nextInt();
        }

        int ele = scn.nextInt();
        System.out.println(find(arr,ele));
        
    }

    public static int find(int arr[],int ele){
        for(int idx = 0 ; idx < arr.length ; idx++){
            if(arr[idx] == ele){
                // element found 
                return idx;
            }
        }
        // element not found
        return -1;
    }

}