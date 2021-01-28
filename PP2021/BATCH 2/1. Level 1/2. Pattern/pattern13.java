import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int input = scn.nextInt();

        for (int n = 0; n < input; n++) {
            int val = 1;
            for (int r = 0; r <= n; r++) {
                System.out.print(val + "\t");
                val = ((n - r) * val) / (r + 1);
            }
            System.out.println();
        }
    }
}