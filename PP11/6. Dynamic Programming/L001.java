import java.util.Scanner;

public class L001 {
    public static void main(String[] args) {
        int n = 4;
        // // int ways = climbStairs(n,new int[n+1]);
        // int ways = climbStairsT(n);
        // System.out.println(ways);
        // minCost();
        coinChangeCombination();
    }

    public static int climbStairs(int n,int dp[]){
        if(n == 0){
            return dp[n] = 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int tways = 0;
        if(n-1 >= 0){
            tways += climbStairs(n-1,dp);// 1 len
        }
        if(n-2 >= 0){
            tways += climbStairs(n-2,dp);// 2 len
        }
        if(n-3 >= 0){
            tways += climbStairs(n-3,dp);// 3 len
        }

        return dp[n] = tways;
    }

    public static int climbStairsT(int n){
        int dp[] = new int[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            if(i == 0){
                dp[0] = 1;
            }else if(i == 1){
                dp[i] = dp[i-1];
            }else if(i == 2){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];
    }

    public static void ClimbStairsWithVariableJump(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int moves[] = new int[n];
        for(int i = 0 ; i < moves.length ; i++){
            moves[i] = scn.nextInt();
        }
        
        // logic
        int dp[] = new int[n+1];
        
        for(int i = n ; i>= 0 ; i--){
            if(i == n){
                dp[i] = 1;
            }else{
                int maxJump = moves[i];
                for(int len = 1 ; len <= maxJump && len + i <= n; len++){
                    dp[i] += dp[i+len];
                }
            }
        }
        
        System.out.println(dp[0]);
    }

    public static void minCost(){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int cost[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                cost[i][j] = scn.nextInt();
            }
        }
        
        // logic 
        int dp[][] = new int[nr][nc];

        for(int r = nr-1 ; r >= 0 ; r--){
            for(int c = nc - 1; c >= 0 ; c--){
                if(r == nr-1 && c == nc-1){
                    dp[r][c] = cost[r][c];
                }else if(r == nr-1){
                    dp[r][c] = dp[r][c+1] + cost[r][c];
                }else if(c == nc-1){
                    dp[r][c] = dp[r+1][c] + cost[r][c];
                }else{
                    dp[r][c] = Math.min(dp[r][c+1],dp[r+1][c])+cost[r][c];
                }
            }
        }

        System.out.println(dp[0][0]);
    }

    public static void targetSumSubsetsDP(){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int coins[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            coins[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        // logic
        boolean dp[][] = new boolean[n+1][tar+1];

        for(int r = 0 ; r <= n ; r++){
            for(int t = 0 ; t <= tar ; t++){
                if(r == 0 && t == 0){
                    dp[0][0] = true;
                }else if(r == 0){
                    dp[r][t] = false;
                }else if(t == 0){
                    dp[r][t] = true;
                }else{
                    int coin = coins[r-1];
                    boolean inc = (t-coin >= 0) ? dp[r-1][t-coin] : false;// inc
                    boolean exc = dp[r-1][t];// exc

                    dp[r][t] = inc || exc;
                }
            }
            if(dp[r][tar] == true){
                System.out.println(true);
                return;
            }
        }

        System.out.println(false);
    }

    public static void coinChangeCombination(){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int coins[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            coins[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        // logic

        int dp[] = new int[tar+1];

        dp[0] = 1;

        for(int coin : coins){
            for(int t = coin ; t <= tar ; t++){
                dp[t] += dp[t-coin];
            }
        }

        System.out.println(dp[tar]);
    }
}
