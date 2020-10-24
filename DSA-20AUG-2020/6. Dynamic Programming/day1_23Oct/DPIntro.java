import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long start = System.currentTimeMillis();
        // System.out.println(fibonacci(n));
        System.out.println(fibonacciDp(n,new int[n+1]));
        long end = System.currentTimeMillis();
        System.out.println("time :"+(end-start));
    }
    
    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        
        int fibNm1 = fibonacci(n-1);
        int fibNm2 = fibonacci(n-2);
        int fibN = fibNm1 + fibNm2;
        
        return fibN;
    }
    
    public static int fibonacciDp(int n,int qb[]){
        if(n == 0 || n == 1){
            qb[n] = n;
            return n;
        }
        
        if(qb[n] != 0){
            // answer exists
            return qb[n];
        }
        
        int fibNm1 = fibonacciDp(n-1,qb);
        int fibNm2 = fibonacciDp(n-2,qb);
        int fibN = fibNm1 + fibNm2;
        
        qb[n] = fibN;
        return fibN;
    }
}