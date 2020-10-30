import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        
        System.out.println(power(x,n));
        
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int xPowNBy2 = power(x,n/2);
        int res = xPowNBy2 * xPowNBy2;
        
        if(n%2 == 1){
            res = res * x;
        }
        
        return res;
    }

}