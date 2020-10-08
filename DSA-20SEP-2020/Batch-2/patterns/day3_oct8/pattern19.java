import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (r == 1) {
                    // group A
                    if ((c >= 1 && c <= (n / 2) + 1) || c == n) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if (r > 1 && r < (n / 2) + 1) {
                    // group B
                    if (c == (n / 2) + 1 || c == n) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if (r == (n / 2) + 1) {
                    // group C
                    System.out.print("*\t");
                } else if (r > (n / 2) + 1 && r < n) {
                    // group D
                    if (c == 1 || c == (n / 2) + 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if (r == n) {
                    // group E
                    if (c == 1 || (c >= (n / 2) + 1 && c <= n)) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }

    }
}