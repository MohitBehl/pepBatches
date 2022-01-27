
import java.io.*;
import java.util.*;

public class PowerLogarithmic {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        // int xPowN = powerFake(x,n);
        int xPowN = powerSmart(x,n);
        System.out.println(xPowN);
    }

    public static int powerFake(int x, int n){
        if(n == 0){
            return 1;
        }
        if(n%2 == 0){
            return powerFake(x,n/2) * powerFake(x,n/2);
        }else{
            return powerFake(x,n/2) * powerFake(x,n/2) * x;
        }
    }
    
    public static int powerSmart(int x, int n){
        if(n == 0){
            return 1;
        }
        int xPowNb2 = powerSmart(x,n/2);
        if(n%2 == 0){
            return  xPowNb2 * xPowNb2;
        }else{
            return xPowNb2 * xPowNb2 * x;
        }
    }

}