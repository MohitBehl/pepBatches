import java.io.*;
import java.util.*;

public class tilingM_1 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int dp[] = new int[n+1];
        
        for(int  i = 0 ; i <= n ; i++){
            if(i == 0){
                dp[0] = 1;
            }else if(i < m){
                dp[i] = 1;
            }else if(i == m){
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        
        System.out.println(dp[n]);
    }
}