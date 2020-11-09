import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int dp[][] = new int[2][n+1];
        
        for(int j = 1 ; j <= n ; j++){
            if(j == 1){
                dp[0][j] = dp[1][j] = 1;
            }else{
                dp[0][j] = dp[1][j-1];
                dp[1][j] = dp[0][j-1] + dp[1][j-1];
            } 
        }
        
        int ans = dp[0][n] + dp[1][n];
        System.out.println(ans);
    }

}