import java.util.*;

public class Main {


    public static int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }

    public static int nCr(int n, int r) {
        int nfact = fact(n);
        int rfact = fact(r);
        int nMrfact = fact(n - r);

        return (nfact / (rfact * nMrfact));
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();

        int val = nCr(n, r);

        System.out.println(val);
    }
}