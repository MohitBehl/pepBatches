import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        int k = baseToDecimal(n, sourceBase);
        int res = decimalToBase(k, destBase);
        System.out.println(res);
    }

    public static int decimalToBase(int n, int destBase) {
        int mul = 1; // 10 to the power 0
        int ans = 0;
        while (n != 0) {
            int rem = n % destBase;

            ans = ans + (rem * mul);

            n = n / destBase;
            mul = mul * 10;
        }

        return ans;
    }

    public static int baseToDecimal(int n, int sourceBase) {
        int ans = 0;
        int mul = 1;

        while (n != 0) {
            int rem = n % 10;
            ans += (rem * mul);

            n /= 10;
            mul *= sourceBase;
        }

        return ans;
    }
}