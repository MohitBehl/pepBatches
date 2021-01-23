import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        // System.out.println(fibR(n));
        // System.out.println(fibDpM(n,new int[n+1]));
        System.out.println(fibDpT(n,new int[n+1]));
        
    }

    public static int fibR(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int fibNm1 = fibR(n-1);
        int fibNm2 = fibR(n-2);
        
        int fibN = fibNm1 + fibNm2;
        
        return fibN;
    }
    public static int fibDpM(int n,int qb[]){
        if(n == 0 || n == 1){
            qb[n] = n;
            return n;
        }
        
        if(qb[n] != 0){
            // fib(n) is already processed
            return qb[n];
        }
        
        int fibNm1 = fibDpM(n-1,qb);
        int fibNm2 = fibDpM(n-2,qb);
        
        int fibN = fibNm1 + fibNm2;
        
        qb[n] = fibN;
        
        return fibN;
    }
    public static int fibDpT(int n,int qb[]){
        for(int i = 0 ; i <= n ; i++){
            
            if(i == 0 || i == 1){
                qb[i] = i;
                continue;
            }
            
            
            int fibNm1 = qb[i-1];
            int fibNm2 = qb[i-2];
            
            int fibN = fibNm1 + fibNm2;
            
            qb[i] = fibN;
        }
        return qb[n];
    }
}