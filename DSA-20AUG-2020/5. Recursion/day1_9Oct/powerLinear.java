import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int num = scn.nextInt();
        int pow = scn.nextInt();
        
        System.out.println(power(num,pow));
    }

    public static int power(int num, int pow){
        if(pow == 0){
            return 1;
        }
        int powNm1 = power(num,pow-1);
        int ans = num * powNm1;
        return ans;
    }

}