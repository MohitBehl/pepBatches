import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        System.out.println(climbStairsDp(n));
    }

    public static int climbStairsDp(int n){
        int qb[] = new int[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            if(i == 0){
                // dest
                qb[0] = 1;
                continue;
            }
            
            int tways = 0;
            if(i >= 1){
                // length 1
                tways += qb[i-1];
            }
            if(i >= 2){
                // length 2
                tways += qb[i-2];
            }
            if(i >= 3){
                // length 3
                tways += qb[i-3];
            }
    
            qb[i] = tways;
            continue;
        }
        
        return qb[n];
    }

}