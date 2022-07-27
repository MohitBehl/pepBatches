import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int cost[][] = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            cost[i][0] = scn.nextInt();
            cost[i][1] = scn.nextInt();
            cost[i][2] = scn.nextInt();
        }

        System.out.println(paintHouse(cost));
    }
    public static int paintHouse(int cost[][]){
        int n = cost.length;
        int mem[][] = new int[n][3];

        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                mem[0][0] = cost[0][0];
                mem[0][1] = cost[0][1];
                mem[0][2] = cost[0][2];
            }else{
                mem[i][0] = Math.min(mem[i-1][1],mem[i-1][2]) + cost[i][0]; 
                mem[i][1] = Math.min(mem[i-1][0],mem[i-1][2]) + cost[i][1];
                mem[i][2] = Math.min(mem[i-1][0],mem[i-1][1]) + cost[i][2];
            }
        }

        return Math.min(Math.min(mem[n-1][0],mem[n-1][1]),mem[n-1][2]);
    }

}