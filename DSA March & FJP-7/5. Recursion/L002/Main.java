import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); 
        int src = scn.nextInt();
        int dest = scn.nextInt();
        int helper = scn.nextInt();
        toh(n,src,dest,helper);
    }
    public static void pzz(int n){
        if(n == 0) return;
        if(n == 1) {System.out.print("111"); return;}
        
        System.out.print(n);
        pzz(n-1);
        System.out.print(n);
        pzz(n-1);
        System.out.print(n);
    }
    public static int fib(int n){
        if(n == 0 || n == 1) return n;
        return fib(n-1) + fib(n-2);
    }
    public static void toh(int n, int src, int dest, int helper){
        if(n == 0) return;
        toh(n-1,src,helper,dest);
        System.out.println(n+"["+src+" -> "+dest+"]");
        toh(n-1,helper,dest,src);
    }

}