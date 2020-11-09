import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int nHouses = scn.nextInt();
        int nColors = scn.nextInt();
        
        int arr[][] = new int[nHouses][nColors];
        
        for(int i = 0 ; i < nHouses ; i++){
            for(int j = 0 ; j < nColors ; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int dp[][] = new int[nHouses][nColors];
        
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        
        for(int c = 0 ; c < nColors ; c++){
            dp[0][c] = arr[0][c];
    
            if(dp[0][c] <= min){
                smin = min;
                min = dp[0][c];
            }else if(dp[0][c] <= smin){
                smin = dp[0][c];
            }
            
        }
        
        for(int h = 1 ; h < nHouses ; h++){
            int least = Integer.MAX_VALUE;
            int sleast = Integer.MAX_VALUE;
            
            for(int c = 0 ; c < nColors ; c++){
                if(dp[h-1][c] == min){
                    dp[h][c] = arr[h][c] + smin;
                }else {
                    dp[h][c] = arr[h][c] + min;
                }
                
                if(dp[h][c] <= least){
                    sleast = least;
                    least = dp[h][c];
                }else if(dp[h][c] <= sleast){
                    sleast = dp[h][c];
                }
            }
            min = least;
            smin = sleast;
        }
        
        System.out.println(min);
    }
}