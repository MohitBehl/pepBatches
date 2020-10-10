import java.util.*;

public class inverseOfNumber{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int number = scn.nextInt();
        int pos = 1;
        int ans = 0;
        while(number != 0){
            int val = number%10;
            ans += (pos*Math.pow(10,val-1));

            pos++;
            number /= 10;
        }

        System.out.println(ans);
    }
}