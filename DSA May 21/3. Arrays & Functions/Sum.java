import java.io.*;
import java.util.*;

public class Sum{

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
    
    
    // logic
    int res[] = new int[n1<n2 ? n2 : n1];
    int p1 = n1-1, p2 = n2-1, p3 = res.length-1, carry = 0;
    
    while(p3 >= 0){
        int v1 = p1 >= 0 ? arr1[p1] : 0;
        int v2 = p2 >= 0 ? arr2[p2] : 0;
        
        int sum = v1 + v2 + carry;
        
        int digit = sum % 10;
        carry = sum/10;
        
        res[p3] = digit;
        
        p1--;
        p2--;
        p3--;
    }
    if(carry != 0){
        System.out.println(carry);
    }
    
    for(int val : res){
        System.out.println(val);
    }
 }

}