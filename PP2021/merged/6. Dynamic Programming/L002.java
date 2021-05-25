import java.io.*;
import java.util.*;

public class L002 {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        // int n = scn.nextInt();
        // int moves[] = new int[n];
        // for(int i = 0 ; i < n ;i++){
        //     moves[i] = scn.nextInt();
        // }
        // int steps = minMoves(moves);
        // if(steps == Integer.MAX_VALUE){
        //     System.out.println("null");
        // }else{
        //     System.out.println(steps);
        // }

        int n = scn.nextInt();
        int coins[] = new int[n];
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        
        System.out.println(coinChangeCombination(coins,tar));
    }
    
    public static int minMoves(int moves[]){
        int n = moves.length;
        int qb[] = new int[n+1];
        
        for(int i = n-1 ; i >= 0 ; i--){
            int maxJmp = moves[i];
            
            if(maxJmp == 0){
                qb[i] = Integer.MAX_VALUE;
            }else{
                int minSteps = Integer.MAX_VALUE;
                for(int jmp = 1 ; jmp <= maxJmp && i+jmp <= n ; jmp++){
                    minSteps = Math.min(minSteps,qb[i+jmp]);
                }
                
                if(minSteps == Integer.MAX_VALUE){
                    qb[i] = Integer.MAX_VALUE;
                }else{
                    qb[i] = minSteps + 1;
                }
            }
        }
        
        return qb[0];
    }

    public static int coinChangeCombination(int coins[],int tar){
        int dp[] = new int[tar+1];
        dp[0] = 1;
        
        for(int i = 0 ; i < coins.length ; i++){
            int coin = coins[i];
            for(int j = coin ; j <= tar ; j++){
                dp[j] += dp[j-coin];
            }
        }
        
        return dp[tar];
    }

    public static int maxGold(int mine[][]){
        int nr = mine.length , nc = mine[0].length;
        int dp[][] = new int[nr][nc];
        
        for(int c = nc-1 ; c>=0 ; c--){
            for(int r = 0 ; r < nr ; r++){
                if(c == nc-1){
                    dp[r][c] = mine[r][c];
                }else{
                    if(r == 0){
                        dp[r][c] = Math.max(dp[r][c+1],dp[r+1][c+1]) + mine[r][c];
                    }else if(r == nr-1){
                        dp[r][c] = Math.max(dp[r][c+1],dp[r-1][c+1]) + mine[r][c];
                    }else{
                        dp[r][c] = Math.max(dp[r][c+1],Math.max(dp[r-1][c+1],dp[r+1][c+1]))+mine[r][c];
                    }
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int r = 0 ; r < nr ;r++){
            max = Math.max(max,dp[r][0]);
        }
        
        return max;
    }

    public static boolean tarSumSubset(int coins[],int tar){
        int n = coins.length;
        boolean dp[][] = new boolean[n+1][tar+1];
        
        for(int r = 0 ; r <= n ;r++){
            for(int c = 0 ; c <= tar ; c++){
                if(r == 0 && c == 0){
                    dp[r][c] = true;
                }else if(r == 0){
                    dp[r][c]  = false;
                }else if(c == 0){
                    dp[r][c] = true;
                }else{
                    int coin = coins[r-1];
                    boolean exc = dp[r-1][c];
                    boolean inc = (c-coin >= 0) ? dp[r-1][c-coin] : false;
                    dp[r][c] = exc || inc;
                }
            }
        }
        
        return dp[n][tar];
    }    
}