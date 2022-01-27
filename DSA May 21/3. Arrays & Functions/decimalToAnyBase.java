import java.util.*;
public class decimalToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
     }
    
     public static int getValueInBase(int n, int b){
         int res = 0;
         int mul = 1;
         while(n != 0){
             int rem = n % b;
             res = res + (rem * mul);
             n = n / b;
             mul = mul * 10;
         }
         return res;
     }
}
