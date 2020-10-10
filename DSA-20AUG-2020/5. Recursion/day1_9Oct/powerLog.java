import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int p = scn.nextInt();
        
        System.out.println(power(n,p));
    }

    public static int power(int n, int p){
        if(p == 0){
            return 1;
        }
        
        int powPb2 = power(n,p/2);
        
        int ans = powPb2 * powPb2;
        
        if(p%2 != 0){
            ans = ans * n;
        }
        
        return ans;
    }

}