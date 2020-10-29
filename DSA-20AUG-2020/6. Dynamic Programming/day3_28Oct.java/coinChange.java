import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int coins[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            coins[i] = scn.nextInt();
        }
        
        int tar = scn.nextInt();
        
        System.out.println(coinChangeCombination(coins,tar));
    }
    
    public static int coinChangeCombination(int coins[] , int finalTarget){
        int dp[] = new int[finalTarget+1];
        
        dp[0] = 1;
        
        for(int i = 0 ; i < coins.length ; i++){
            int val = coins[i];
            
            for(int tar = val ; tar <= finalTarget ; tar++){
                dp[tar] += dp[tar-val];
            }
        }
        
        return dp[finalTarget];
    }
}