import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1, nsp = n / 2, nst = 1; // preparation for 1st row only

        while (row <= n) {
            // print spaces
            for (int i = 1; i <= nsp; i++) {
                System.out.print("\t");
            }

            // print stars
            for (int i = 1; i <= nst; i++) {
                System.out.print("*\t");
            }

            System.out.println(); //  new line

            // preparation for next row 

            if (row <= n / 2) {
                nsp--;
                nst += 2;
            } else {
                // (row > n/2)
                nsp++;
                nst -= 2;
            }

            row++;
        }

    }
}