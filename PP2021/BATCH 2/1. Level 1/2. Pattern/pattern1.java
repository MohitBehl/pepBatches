import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        // code
        for (int r = 1; r <= n; r++) {
            int nst = r;
            // row : stars print + new line 
            for (int i = 1; i <= nst; i++) {
                System.out.print("*\t");
            }
            System.out.println();
        }

    }
}