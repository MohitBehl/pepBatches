import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int val = 1;
        for (int r = 1; r <= n; r++) {
            int nst = r;
            for (int i = 1; i <= nst; i++) {
                System.out.print(val + "\t");
                val++;
            }
            System.out.println();
        }

    }
}