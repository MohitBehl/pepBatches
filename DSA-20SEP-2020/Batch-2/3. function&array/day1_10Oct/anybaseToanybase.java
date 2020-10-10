import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        
        int dv = getValueIndecimal(n,sourceBase);
        int ans = getValueInBase(dv,destBase);
        System.out.println(ans);
    }
    public static int getValueIndecimal(int n, int b) {
        int pv = 0;
        int mult = 1;

        while (n != 0) {
            int rem = n % 10;
            pv = pv + (rem * mult);

            mult = mult * b;
            n = n / 10;
        }

        return pv;
    }

    public static int getValueInBase(int n, int b) {

        int mult = 1;
        int ans = 0;
        while (n != 0) {
            int rem = n % b;

            ans = ans + (rem * mult);

            n = n / b;
            mult = mult * 10;
        }

        return ans;
    }
}