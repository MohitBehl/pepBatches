import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       int nr = scn.nextInt();
       int nc = scn.nextInt();
       
       int ground[][] = new int[nr][nc];
       
       for(int i = 0 ; i < nr ; i++){
           for(int j = 0 ; j < nc ; j++){
               ground[i][j] = scn.nextInt();
           }
       }
       
       System.out.println(goldMine(ground));
    }

    public static int goldMine(int ground[][]){
        int nr = ground.length , nc = ground[0].length;
        int dp[][] = new int[nr][nc];
        
        for(int c = nc-1 ; c >=0 ; c--){
            for(int r = 0 ; r < nr ; r++){
                if(c == nc-1){
                    // last column
                    dp[r][c] = ground[r][c];
                }else{
                    // traverse
                    int tmp = Integer.MIN_VALUE;
                    if(r-1 >= 0){
                        // validation for first row
                        tmp = Math.max(tmp,dp[r-1][c+1]);
                    }
                    
                    tmp = Math.max(tmp,dp[r][c+1]);
                    
                    if(r+1 < nr){
                        // validation for last row
                        tmp = Math.max(tmp,dp[r+1][c+1]);
                    }
                    
                    dp[r][c] = ground[r][c] + tmp;
                }
            }
        }
        
        int res = Integer.MIN_VALUE;
        
        for(int r = 0 ; r < nr ; r++){
            res = Math.max(res,dp[r][0]);
        }
        
        return res;
    } 
}