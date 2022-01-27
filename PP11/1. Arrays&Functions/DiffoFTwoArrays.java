import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
     Scanner scn = new Scanner(System.in);
    
    int n1 = scn.nextInt();
    int arr1[] = new int[n1];
    for(int i = 0 ; i < n1 ; i++){
        arr1[i] = scn.nextInt();
    }
    
    int n2 = scn.nextInt();
    int arr2[] = new int[n2];
    for(int i = 0 ; i < n2 ; i++){
        arr2[i] = scn.nextInt();
    }
    
    // diff of two arrays
    
    int size = n2;
    int res[] = new int[size];
    
    int p1=n1-1 , p2=n2-1 , p3 = size-1 , borrow = 0;
    
    while(p2 >= 0){
        int d1 = p1 < 0 ? 0 : arr1[p1];
        int d2 = arr2[p2];
        
        int diff = d2 - d1 - borrow;
        if(diff < 0){
            diff = diff + 10;
            borrow = 1;
        }else{
            borrow = 0;
        }
        
        res[p3] = diff;
        p1--;
        p2--;
        p3--;
    }
    
    // output
    boolean flag = false;
    for(int idx = 0 ; idx < size ; idx++){
        if(res[idx] != 0){
            flag = true;
        }
        if(flag){
            System.out.println(res[idx]);
        }
    }
 }

}