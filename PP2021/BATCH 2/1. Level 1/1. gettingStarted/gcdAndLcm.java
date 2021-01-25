import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num1 = scn.nextInt();
        int num2 = scn.nextInt();

        // create copy
        int tmp1 = num1;
        int tmp2 = num2;

        // GCD
        while (num2 % num1 != 0) {
            int rem = num2 % num1;
            num2 = num1;
            num1 = rem;
        }
        int GCD = num1;

        // LCM = (n1*n2)/GCD;
        int LCM = (tmp1 * tmp2) / GCD;

        System.out.println(GCD + "\n" + LCM);
    }
}