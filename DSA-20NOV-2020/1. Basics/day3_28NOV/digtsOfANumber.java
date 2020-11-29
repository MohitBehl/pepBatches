import java.util.*;
public class digtsOfANumber {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        // power corresponding to number of digits

        int tmp = num;
        int pow = 1;
        while(tmp >= 10){
            tmp = tmp/10;
            pow = pow * 10;
        }

        while(pow != 0){
            int digit = num / pow; // left most digit
            System.out.println(digit);

            // preparation for next iteration
            num = num % pow;
            pow = pow / 10;
        }
    }
}
