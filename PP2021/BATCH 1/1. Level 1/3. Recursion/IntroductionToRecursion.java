import java.util.Arrays;
import java.util.Scanner;

public class IntroductionToRecursion {
    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n); // my work
        printDecreasing(n - 1); //  faith
    }

    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int nM1Fact = factorial(n - 1);
        int nFact = n * nM1Fact;
        
        return nFact;
    }

    public static int powerLinear(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xPowNm1 = powerLinear(x, n - 1); // faith
        int xPowN = x * xPowNm1;
        return xPowN;
    }

    public static int powerLogarithmic(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xPowNb2 = powerLogarithmic(x, n / 2);
        int ans = xPowNb2 * xPowNb2;
        if (n % 2 == 1) {
            ans = ans * x;
        }
        return ans;
    }
    
    public static void pzz(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        
    }

    public static void toh(int n, int src, int dest, int helper) {
        if (n == 0) {
            return;
        }
        toh(n - 1, src, helper, dest);
        System.out.println(n + "[" + src + " -> " + dest + "]");
        toh(n - 1, helper, dest, src);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();

        // int nFact = factorial(n);

        // System.out.println(nFact);

        // int x = scn.nextInt();
        // int n = scn.nextInt();

        // System.out.println(powerLinear(x, n));

        // int n = scn.nextInt();

        // pzz(n);

        int nDisc = scn.nextInt();
        int src = scn.nextInt();
        int dest = scn.nextInt();
        int helper = scn.nextInt();

        toh(nDisc, src, dest, helper);
    }
}
