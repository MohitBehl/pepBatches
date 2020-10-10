import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int factN = factorial(n);
        
        System.out.println(factN);
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int factNm1 = factorial(n-1); // faith
        int factN = n * factNm1;
        return factN;
    }

}