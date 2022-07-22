import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(countBinaryString_tab(n));
    }
    public static int countBinaryString_tab(int n){
        int mem[][] = new int[2][n+1];

        for(int c = 1 ; c <= n ;c++){
            if(c == 1){
                mem[0][c] = mem[1][c] = 1;
            }else{
                mem[0][c] = mem[1][c-1];
                mem[1][c] = mem[0][c-1] + mem[1][c-1];   
            }
        }

        return mem[0][n] + mem[1][n];
    }

}