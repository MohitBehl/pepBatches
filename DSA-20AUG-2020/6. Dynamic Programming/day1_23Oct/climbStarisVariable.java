import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int jump[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            jump[i] = scn.nextInt();
        }
        System.out.println(climbStairsVariable(0,jump,new int[n+1]));
    }
    public static int climbStairsVariable(int pos , int jump[],int qb[]){
        if(pos == jump.length){
            // destination
            qb[pos] = 1;
            return 1;
        }
        // if(pos > jump.length){
        //     // invalid pos
        //     return 0;
        // }
        if(qb[pos] != 0){
            // answer exists
            return qb[pos];
        }
        int maxjmp = jump[pos];
        int tways = 0;
        for(int step = 1 ; step <= maxjmp ; step++){
            if(pos+step <= jump.length){
                tways += climbStairsVariable(pos+step,jump,qb);
            }
        }
        qb[pos] = tways;
        return tways;
    }
}