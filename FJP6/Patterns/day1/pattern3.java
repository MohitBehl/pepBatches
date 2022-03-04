import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for(int row = 1 ; row <= n ; row++){
            int nst = row;
            int nsp = n - nst;

            for(int i = 1 ; i <= nsp ; i++){
                System.out.print(" \t");
            }

            for(int i = 1 ; i <= nst ; i++){
                System.out.print("*\t");
            }

            System.out.println();
        }

    }
}