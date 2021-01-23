import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        // System.out.println(climbStairsR(n));
        // System.out.println(climbStairsDpM(n,new int[n+1]));
        System.out.println(climbStairsDpT(n,new int[n+1]));
    }
    
    public static int climbStairsR(int n){
        if(n == 0){
            // no stairs to climb :  dest
            return 1;
        }
        int totalWays = 0;
        if(n-1 >= 0){
            totalWays += climbStairsR(n-1);// 1 len
        }
        if(n-2 >= 0){
            totalWays += climbStairsR(n-2);// 2 len
        }
        if(n-3 >= 0){
            totalWays += climbStairsR(n-3);// 3 len
        }
        return totalWays;
    }
    
    public static int climbStairsDpM(int n,int qb[]){
        if(n == 0){
            // no stairs to climb :  dest
            return qb[0] = 1;
        }
        
        if(qb[n] != 0){
            return qb[n];
        }
        
        int totalWays = 0;
        if(n-1 >= 0){
            totalWays += climbStairsDpM(n-1,qb);// 1 len
        }
        if(n-2 >= 0){
            totalWays += climbStairsDpM(n-2,qb);// 2 len
        }
        if(n-3 >= 0){
            totalWays += climbStairsDpM(n-3,qb);// 3 len
        }
        
        return qb[n] = totalWays;
    }
    
    public static int climbStairsDpT(int n,int qb[]){
        for(int i = 0 ; i <= n ; i++){
            if(i == 0){
                // no stairs to climb :  dest
                qb[0] = 1;
                continue;
            }
            
            int totalWays = 0;
            if(i-1 >= 0){
                totalWays += qb[i-1];// 1 len
            }
            if(i-2 >= 0){
                totalWays += qb[i-2];// 2 len
            }
            if(i-3 >= 0){
                totalWays += qb[i-3];// 3 len
            }
            
            qb[i] = totalWays;
            continue;
        }
        return qb[n];
    }

    
}