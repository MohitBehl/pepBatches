import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int cost[][] = new int[n][k];
        for(int i = 0 ; i < n ; i++){
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
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for(int house = 0 ; house < n ; house++){
            int tmin = Integer.MAX_VALUE;
            int tsmin = Integer.MAX_VALUE;
            for(int color = 0 ; color < k ; color++){
                if(house == 0){
                    mem[house][color] = cost[house][color];
                }else{
                    int costOfColoringTillPrevhouse = mem[house-1][color];
                    if(costOfColoringTillPrevhouse == min){
                        mem[house][color] = cost[house][color] + smin;
                    }else{
                        mem[house][color] = cost[house][color] + min;
                    }
                }
                if(mem[house][color] <= tmin){
                    tsmin = tmin;
                    tmin = mem[house][color];
                }else if(mem[house][color] <= tsmin){
                    tsmin = mem[house][color];
                }
            }

            min = tmin;
            smin = tsmin;
        }
        return min;
    }
}