import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int vls[] = new int[n];
        for(int i = 0 ; i < vls.length ; i++){
            vls[i] = scn.nextInt();
        }
        int wts[] = new int[n];
        for(int i = 0 ; i < wts.length ; i++){
            wts[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        
        System.out.println(zeroOneKnapSack(vls,wts,cap));
    }
    public static int zeroOneKnapSack(int vls[],int wts[] , int totalCap){
        int n = vls.length;
        
        int dp[][] = new int[n+1][totalCap+1];
        
        for(int r = 1 ; r <= n ; r++){
            int val = vls[r-1] , wt = wts[r-1];
            for(int currCap = 1 ; currCap <= totalCap ; currCap++){
                if(wt > currCap){
                    dp[r][currCap] = dp[r-1][currCap];
                }else{
                    int remCap = currCap-wt;
                    dp[r][currCap] = Math.max(dp[r-1][currCap] , (dp[r-1][remCap] + val));
                }
            }
        }
        
        return dp[n][totalCap];
    }
}