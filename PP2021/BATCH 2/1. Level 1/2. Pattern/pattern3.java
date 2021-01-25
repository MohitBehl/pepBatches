import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for (int r = 1; r <= n; r++) {
            int nst = r;
            int nsp = n - nst;
            // print spaces
            for (int i = 1; i <= nsp; i++) {
                System.out.print("\t");
            }
            // print stars
            for (int i = 1; i <= nst; i++) {
                System.out.print("*\t");
            }
            // new line
            System.out.println();
        }

    }
}