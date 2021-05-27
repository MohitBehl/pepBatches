import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int idx = 0 ; idx < n ; idx++){
        arr[idx] = scn.nextInt();
    }
    int k = scn.nextInt();
    
    
    // logic 
    
    // int ans = -1;
    // for(int idx = 0 ;idx < n ; idx++){
    //     if(arr[idx] == k){
    //         ans = idx;
    //         break;
    //     }
    // }
    
    // System.out.println(ans);
    boolean flag = false;
    for(int idx = 0 ; idx < n ; idx++){
        if(arr[idx] == k){
            System.out.println(idx);
            flag = true;
            break;
        }
    }
    
    if(flag == false){
        System.out.println("-1");
    }
    
    
 }

}