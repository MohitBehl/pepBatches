import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        for (int fac = 2; fac * fac <= num; fac++) {
            while (num % fac == 0) {
                num = num / fac;
                System.out.print(fac + " ");
            }
        }

        if (num != 1) {
            System.out.println(num);
        }
    }
}