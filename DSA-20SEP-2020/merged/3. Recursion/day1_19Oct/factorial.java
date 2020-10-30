import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        System.out.println(factorial(n));
        
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int fNm1 = factorial(n-1); // faith
        int fn = n * fNm1;
        return fn;
    }

}