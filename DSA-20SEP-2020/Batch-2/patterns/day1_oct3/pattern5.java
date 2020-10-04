import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        int row = 1 , nst = 1 , nsp = n/2;

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
            // new line 
            System.out.println();

            // preparation

            if(row <= n/2){
                // preparation for upper half rows
                nst += 2;
                nsp--;
            }else{
                // preparation for lower half rows
                nst -= 2;
                nsp++;
            }
            row++;
        }

    }
}