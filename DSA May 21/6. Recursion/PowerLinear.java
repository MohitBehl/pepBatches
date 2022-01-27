import java.io.*;
import java.util.*;

public class PowerLinear {

    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       
       int x = scn.nextInt();
       int n = scn.nextInt();
       
       int xPowN = power(x,n);
       System.out.println(xPowN);
    }

    public static int power(int x, int n){
        if(n == 0 || x == 1){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(x == 0){
            return 0;
        }
        int xPowNm1 = power(x,n-1);
        int xPowN = x * xPowNm1;
        
        return xPowN;
    }

}