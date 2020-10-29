import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        System.out.println(targetSum(arr,tar));
        
    }
    
    public static boolean targetSum(int arr[],int tar){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][tar+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= tar ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if(j == 0){
                    dp[i][j] = true;
                }else{
                    
                    int t = j;
                    int ele = arr[i-1];
                    boolean res = false;
                    
                    if(t-ele >= 0){
                        // include/contribute
                        res = res || dp[i-1][t-ele];
                    }
                    
                    // not-included / no-contribution
                    res = res || dp[i-1][t];

                    dp[i][j] = res;
                }
            }
        }
        return dp[n][tar];
    }
}