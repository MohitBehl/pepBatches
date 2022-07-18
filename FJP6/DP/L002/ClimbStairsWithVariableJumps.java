import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int moves[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            moves[i] = scn.nextInt();
        }

        // System.out.println(climbStairsVarJump_rec(0,n,moves));
        int mem[] = new int[n+1];
        Arrays.fill(mem,-1);
        System.out.println(climbStairsVarJump_mem(0,n,moves,mem));
    }
    public static int climbStairsVarJump_rec(int currStep,int totalStep,int moves[]){
        if(currStep == totalStep){
            return 1;
        }
        int maxJump = moves[currStep];
        int ans = 0;
        for(int step = 1 ; step <= maxJump ; step++){
            if(currStep + step <= totalStep){
                ans += climbStairsVarJump_rec(currStep + step,totalStep,moves);
            }
        }
        return ans;
    }
    public static int climbStairsVarJump_mem(int currStep,int totalStep,int moves[],int mem[]){
        if(currStep == totalStep){
            return mem[currStep] = 1;
        }
        if(mem[currStep] != -1){
            return mem[currStep];
        }
        int maxJump = moves[currStep];
        int ans = 0;
        for(int step = 1 ; step <= maxJump ; step++){
            if(currStep + step <= totalStep){
                ans += climbStairsVarJump_mem(currStep + step,totalStep,moves,mem);
            }
        }
        return mem[currStep] = ans;
    }

}