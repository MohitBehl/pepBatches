import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        int row = 1;
        int nsp = 0;
        int nst = n;

        while(row <= n){
            // code for each row 
                // 1. print spaces
                for(int i = 1 ; i <= nsp ; i++){
                    System.out.print("\t");
                }
                // 2. print stars
                for(int i = 1 ; i <= nst ; i++){
                    System.out.print("*\t");
                }
            // move to new line 
            System.out.println();
            // preparation for next row 
            row++;
            nsp++;
            nst--;
        }
    }
}