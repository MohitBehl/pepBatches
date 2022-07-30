import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int ans = fib_mem(n,new int[n+1]);
        System.out.println(ans);
    }

    public static int fib_mem(int n,int mem[]){
        if(n == 0 || n == 1){
            return mem[n] = n; // store & return
        }

        if(mem[n] != 0){
            return mem[n]; // reuse
        }
        int ans = fib_mem(n-1,mem) + fib_mem(n-2,mem);

        return mem[n] = ans; // store & return
    }

     public static int climbStairs(int n,int mem[]){
        if(n == 0){
            return mem[0] = 1;
        }
        if(mem[n] != 0){
            return mem[n];
        }
        int ans = 0;
        if(n >= 1){
            ans += climbStairs(n-1,mem);
        }
        if(n >= 2){
            ans += climbStairs(n-2,mem);
        }
        if(n >= 3){
            ans += climbStairs(n-3,mem);
        }
        return mem[n] = ans;
    }
}