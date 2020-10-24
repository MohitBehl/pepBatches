import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        System.out.println(fibonacciDp(n));
    }
    
    public static int fibonacciDPTab(int n){
        // memory creation
        int mem[] = new int[n+1];
        
        // answer the easiest problem(question)
        mem[0] = 0;
        mem[1] = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int fibNm1 = mem[i-1];
            int fibNm2 = mem[i-2];
            int fibN = fibNm1 + fibNm2;
            
            mem[i] = fibN;
        }
        
        return mem[n];
    }
    
    public static int fibonacciDp(int n){
        // memory creation
        int qb[] = new int[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            if(i == 0 || i == 1){
                qb[i] = i;
                // return n;
                continue;
            }
            
            int fibNm1 = qb[i-1];
            int fibNm2 = qb[i-2];
            int fibN = fibNm1 + fibNm2;
            
            qb[i] = fibN;
            // return fibN;
            continue;
        }
        
        return qb[n];
    }
    
}