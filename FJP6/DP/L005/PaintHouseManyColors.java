import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt() , k = scn.nextInt();
        int cost[][] = new int[n][k];
        for(int i =  0 ; i < n ; i++){
            for(int j = 0 ; j < k ; j++){
                cost[i][j] = scn.nextInt();
            }
        }

        int ans = minCost(cost);
        System.out.println(ans);
 
    }
    public static int minCost(int cost[][]){
        int n = cost.length , k = cost[0].length;
        int mem[][] = new int[n][k];

        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int nmin = Integer.MAX_VALUE,nsmin = Integer.MAX_VALUE;
            for(int j = 0 ; j < k ; j++){
                if(i == 0){
                    mem[i][j] = cost[i][j];
                }else if(mem[i-1][j] == min){
                    mem[i][j] = smin + cost[i][j];
                }else{
                    mem[i][j] = min + cost[i][j];
                }

                if(mem[i][j] < nmin){
                    nsmin = nmin;
                    nmin = mem[i][j];
                }else if(mem[i][j] < nsmin){
                    nsmin = mem[i][j];
                }
            }
            min = nmin;
            smin = nsmin;
        }

        return min;
    }
}