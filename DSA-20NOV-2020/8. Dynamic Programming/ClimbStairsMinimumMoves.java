import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int moves[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            moves[i] = scn.nextInt();
        }
        
        System.out.println(CSMinimumMovesDpT(moves));
    }
    
    public static int CSMinimumMovesDpT(int moves[]){
        int n = moves.length;
        int qb[] = new int[n+1];
        
        for(int i = n ; i >= 0 ; i--){
            if(i == n){
                // dest 
                qb[n] = 0;
            }else{
                int maxJump = moves[i];
                int min = Integer.MAX_VALUE;
                
                for(int len = 1 ; len <= maxJump && i + len <= n; len++){
                    min = Math.min(min,qb[i+len]);
                }
                
                qb[i] = (min == Integer.MAX_VALUE) ? min : min+1;
            }
        }
        return qb[0];
    }

}