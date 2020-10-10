import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);


        int n = scn.nextInt();

        int row = 1, nst = 1, nsp = 2 * n - 3;

        while (row <= n) {
            // code for each row
            // print stars --> left part
            for (int i = 1; i <= nst; i++) {
                System.out.print(i+"\t");
            }
            // print spaces 
            for (int i = 1; i <= nsp; i++) {
                System.out.print("\t");
            }
            // print stars --> right part
                if (row == n) {
                    nst--;
                }
            for (int i = nst; i >= 1; i--) {
                System.out.print(i+"\t");
            }
            // new line 
            System.out.println();
            
            // preparation for next row 
            
            row++;
            nst++;
            nsp -= 2;
        }

    }
}