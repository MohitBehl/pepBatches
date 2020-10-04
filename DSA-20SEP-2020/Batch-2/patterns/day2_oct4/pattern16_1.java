import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);


        int n = scn.nextInt();

        int row = 1, nst = 1, nsp = 2 * n - 3;

        while (row <= n) {
            // code for each row
            // print stars --> left part
            int leftValue = 1;
            for (int i = 1; i <= nst; i++) {
                System.out.print(leftValue+"\t");
                leftValue++;
            }
            // print spaces 
            for (int i = 1; i <= nsp; i++) {
                System.out.print("\t");
            }
            // print stars --> right part
            int rightValue = row;
            if (row == n) {
                nst--;
                rightValue = n-1;
            }
            for (int i = 1; i <= nst; i++) {
                System.out.print(rightValue+"\t");
                rightValue--;
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