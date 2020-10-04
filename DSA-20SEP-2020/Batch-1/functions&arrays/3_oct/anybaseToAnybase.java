import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();

        // sourceBase to decimal
        int decimalValue = getValueIndecimal(n, sourceBase);
        // decimal to destBase
        int res = getValueInBase(decimalValue, destBase);
        System.out.println(res);
    }
    public static int getValueIndecimal(int n, int b) {
        int ans = 0;
        int mult = 1;

        while (n != 0) {
            int rem = n % 10;
            n = n / 10;
            ans = ans + (rem * mult);
            mult = mult * b;
        }

        return ans;
    }

    public static int getValueInBase(int n, int b) {
        // write code here

        int ans = 0;
        int pow = 1;
        while (n != 0) {
            int rem = n % b;
            ans += (rem * pow);

            n = n / b;
            pow = pow * 10;
        }

        return ans;
    }
}