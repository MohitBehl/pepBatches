import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int arr[][] = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
            arr[i][2] = scn.nextInt();
        }
        
        int dp[][] = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                // first house 
                dp[0][0] = arr[0][0];
                dp[0][1] = arr[0][1];
                dp[0][2] = arr[0][2];
            }else{
                // house --> red color
                dp[i][0] = arr[i][0] + Math.min(dp[i-1][1] , dp[i-1][2]);
                // house --> blue color
                dp[i][1] = arr[i][1] + Math.min(dp[i-1][0] , dp[i-1][2]);
                // house --> green color
                dp[i][2] = arr[i][2] + Math.min(dp[i-1][0] , dp[i-1][1]);
            }
        }
        
        int ans = Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
        System.out.println(ans);
    }
}