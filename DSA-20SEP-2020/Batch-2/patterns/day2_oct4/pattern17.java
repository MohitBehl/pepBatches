import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1, nsp = n / 2, nst = 1;

        while (row <= n) {
            // code for each row
            // 1. print spaces
            for (int i = 1; i <= nsp; i++) {
                if (row == (n / 2) + 1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            // 2. print stars
            for (int i = 1; i <= nst; i++) {
                System.out.print("*\t");
            }
            // new line 
            System.out.println();
            // preparation
            if (row <= n / 2) {
                // upper-half
                nst++;
            } else {
                // lower-half
                nst--;
            }
            row++;
        }

    }
}