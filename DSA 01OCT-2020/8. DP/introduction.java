import java.util.Scanner;
public class Main{
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        // System.out.println(fib(n));
        // System.out.println(fibM(n,new int[n+1]));
        // System.out.println(fibT(n));
        System.out.println(fibTConverted(n));
    }
    
    public static int fib(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int fibNm1 = fib(n-1);
        int fibNm2 = fib(n-2);
        
        int fibN = fibNm1 + fibNm2;
        
        return fibN;
    }
    
    public static int fibM(int n,int qb[]){
        if(n == 1){
            return qb[1] = 0;
        }
        if(n == 2){
            return qb[2] = 1;
        }
        
        if(qb[n] != 0){
            // answer has been calculated.
            return qb[n];
        }
        
        int fibNm1 = fibM(n-1,qb);
        int fibNm2 = fibM(n-2,qb);
        
        int fibN = fibNm1 + fibNm2;
        
        return qb[n] = fibN;
    }
    
    public static int fibTConverted(int n){
        int qb[] = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            if(i == 1){
                qb[1] = 0;
                continue;
            }
            if(i == 2){
                qb[2] = 1;
                continue;
            }
            
            int fibNm1 = qb[i-1]; // fibM(n-1,qb);
            int fibNm2 = qb[i-2]; // fibM(n-2,qb);
            
            int fibN = fibNm1 + fibNm2;
            
            qb[i] = fibN;
        }
        
        return qb[n];
    }
    
    public static int fibT(int  n){
        int qb[] = new int[n+1];
        
        for(int i = 1 ; i <= n ; i++){
            if(i == 1){
                qb[i] = 0;
            }else if(i == 2){
                qb[i] = 1;
            }else{
                qb[i] = qb[i-1]+qb[i-2];
            }
        }
        return qb[n];
    }
    
}