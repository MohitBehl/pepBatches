import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int cost[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                cost[i][j] = scn.nextInt();
            }
        }

        System.out.println(minCost(cost));
    }

    public static int minCost(int cost[][]){
        int nr = cost.length , nc = cost[0].length;
        int mem[][] = new int[nr][nc];

        for(int r = nr-1 ; r >= 0 ; r--){
            for(int c = nc-1; c >= 0 ; c--){
                if(r == nr-1 && c == nc-1){
                    mem[r][c] = cost[r][c];
                }else if(r == nr-1){
                    mem[r][c] = mem[r][c+1] + cost[r][c];
                }else if(c == nc-1){
                    mem[r][c] = mem[r+1][c] + cost[r][c];
                }else{
                    mem[r][c] = Math.min(mem[r][c+1],mem[r+1][c])+cost[r][c];
                }
            }
        }

        return mem[0][0];
    }

}