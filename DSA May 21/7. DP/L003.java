import java.util.*;

public class L003 {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int coins[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            coins[i] = scn.nextInt();
        }
        
        int tar = scn.nextInt();
        int res = tarSumSubset(coins,tar);
        System.out.println(res);
    }
    
    public static boolean tarSumSubset(int coins[],int tar){
        int n = coins.length;
        boolean mem[][] = new boolean[n+1][tar+1];


        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ;  j <= tar ; j++){
                if(j == 0){
                    mem[i][j] = true;
                }else if(i == 0){
                    mem[i][j] = false;
                }else{
                    int coin = coins[i-1];
                    mem[i][j] = mem[i-1][j];
                    if(j-coin >= 0){
                        mem[i][j] = mem[i][j] || mem[i-1][j-coin];
                    }
                }
            }

            if(mem[i][tar]){
                return true;
            }
        }

        return false;
    }

    public static int coinChangeCombination(int coins[],int tar){
        int mem[] = new int[tar+1];
        
        mem[0] = 1;
        
        for(int coin : coins){
            for(int j = coin ; j <= tar ; j++){
                mem[j] += mem[j-coin];
            }
        }
        
        return mem[tar];
    }


    public static int coinChangePermutation(int coins[],int tar){
        int mem[] = new int[tar+1];
        mem[0] = 1;
        for(int j = 1 ; j <= tar ; j++){
            for(int coin : coins){
                if(coin <= j){
                    mem[j] += mem[j-coin];
                }
            }
        }
        
        return mem[tar];
    }

    
}