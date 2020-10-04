import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        for(int row = 1 ; row <= n ; row++){
            int nst = row;
            int nsp = n-row;

            // print spaces
            for(int i = 1 ; i <= nsp ; i++){
                System.out.print("\t");
            }
            // print stars
            for(int i = 1 ; i <= nst ; i++){
                System.out.print("*\t");
            }
            // move to nextline 
            System.out.println();
        }

    }
}