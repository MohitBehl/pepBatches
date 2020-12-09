import java.io.*;
import java.util.*;

public class Main {

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
        
        int res[] = sum(arr1,arr2);
        
        for(int i = 0 ; i < res.length ; i++){
            System.out.println(res[i]);
        }
    }
    
    public static int[] sum(int arr1[] , int arr2[]){
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        int res[] = new int[n1>n2 ? n1 : n2];
        
        int i = n1-1 , j = n2-1 , k = res.length-1 , carry = 0;
        
        while(i >= 0 || j >= 0){
            int v1 = i >= 0 ? arr1[i] : 0;
            int v2 = j >= 0 ? arr2[j] : 0;
            
            int sum = v1 + v2 + carry;
            
            int digit = sum % 10;
            
            carry = sum / 10;
            
            res[k] = digit;
            i--;
            j--;
            k--;
        }
        
        if(carry == 0){
            return res;
        }else{
            // carry is not utilized
            // array resize 
            int resizedRes[] = new int[res.length+1];
            
            resizedRes[0] = carry;
            
            for(int idx = 0 ; idx < res.length ; idx++){
                resizedRes[idx+1] = res[idx];
            }
            
            return resizedRes;
        }
    }

}