import java.io.*;
import java.util.*;
public class SumOfTwoArrays {
    public static void main(String[] args){
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
        
        // add two arrays
        
        int size = n1 > n2 ? n1 : n2;
        int res[] = new int[size];
        
        int p1=n1-1 , p2=n2-1 , p3 = size-1 , carry = 0;
        
        while(p1 >= 0 || p2 >= 0){
            int d1 = p1 < 0 ? 0 : arr1[p1];
            int d2 = p2 < 0 ? 0 : arr2[p2];
            
            int sum = d1 + d2  + carry;
            int digit = sum % 10;
            carry = sum / 10;
            
            res[p3] = digit;
            p1--;
            p2--;
            p3--;
        }
        
        // output
        if(carry != 0){
            System.out.println(carry);
        }
        for(int val : res){
            System.out.println(val);
        }
     }
}
