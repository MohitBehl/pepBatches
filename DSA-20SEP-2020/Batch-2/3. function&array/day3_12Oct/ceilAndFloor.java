import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();


        // ceil & floor
        int ceil = 0;
        int floor = 0;
        int li = 0, ri = arr.length-1;
        
        while(li <= ri){
            int mid = (li + ri)/2;

            if(arr[mid] == d){
                // element found
                floor = ceil = arr[mid];
                break;
            }else if(d > arr[mid]){
                // larger area
                li = mid + 1;
                floor = arr[mid];
            }else if(d < arr[mid]){
                // smaller area
                ri = mid - 1;
                ceil = arr[mid];
            }
        }

        System.out.println(ceil);
        System.out.println(floor);
    }

}