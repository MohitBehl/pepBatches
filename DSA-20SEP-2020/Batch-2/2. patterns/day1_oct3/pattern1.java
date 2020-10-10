import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        for(int r = 1 ; r <= n ; r++){
            int nst = r;

            // 1. print stars
            for(int i = 1 ; i <= nst ; i++){
                System.out.print("*\t");
            }
            // 2. move to next line
            System.out.println();
        }

    }
}