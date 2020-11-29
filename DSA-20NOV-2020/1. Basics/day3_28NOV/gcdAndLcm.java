import java.util.Scanner;

public class gcdAndLcm {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt(),n2 = scn.nextInt();

        int t1 = n1 , t2 = n2;


        while(t1 % t2 != 0){
            int rem = t1 % t2;

            t1 = t2;
            t2 = rem;
        }

        int GCD = t2;
        int LCM = (n1 * n2)/GCD;

        System.out.println(GCD);
        System.out.println(LCM);
    }
}
