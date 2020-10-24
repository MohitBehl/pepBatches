import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int jumps[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            jumps[i] = scn.nextInt();
        }
        
        System.out.println(minimumMoves(0,jumps,new int[n+1]));
    }
    
    public static int minimumMoves(int idx , int jumps[],int qb[]){
        if(idx == jumps.length){
            // destination
            qb[idx] = 0;
            return 0;
        }
        
        if(qb[idx] != 0){
            return qb[idx];
        }
        
        int maxJump = jumps[idx];
        int myMin = Integer.MAX_VALUE;
        
        for(int step = 1 ; step <= maxJump ; step++){
            if(idx+step <= jumps.length){
               int val = minimumMoves(idx+step,jumps,qb);   
               if(myMin > val){
                   myMin = val;
               }
            }
        }
        
        if(myMin != Integer.MAX_VALUE){
            // destination has been reached
            myMin = myMin+1;
        }
        
        qb[idx] = myMin;
        return myMin;
    }

}