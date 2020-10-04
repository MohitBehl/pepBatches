import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1 , nsp = 1 , nst = (n+1)/2;

        while(row <= n){
            // code for each row 
                // 1. print stars
                 for(int i  = 1; i <= nst ; i++){
                     System.out.print("*\t");
                 }
                // 2. print spaces
                 for(int i = 1; i <= nsp ; i++){
                     System.out.print("\t");
                 }
                 
                // 3. print stars
                for(int i  = 1; i <= nst ; i++){
                    System.out.print("*\t");
                }
            // move to new line
                System.out.println();

            // preparation for next row
            if(row <= n/2){
                // 1st part
                nsp += 2;
                nst--;
            }else{
                // 2nd part
                nst++;
                nsp -= 2;
            }
            row++;
        }
    }
}