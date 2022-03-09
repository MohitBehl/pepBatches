import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1 , nspaces = n/2 , nstars = 1;

        while(row <= n){
            // code for each row
                //1. spaces 
            for(int i = 1 ; i <= nspaces ; i++){
                System.out.print("\t");
            }
                //2. stars
            for(int i = 1 ; i <= nstars ; i++){
                if(i == 1 || i == nstars){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }

            // move to new line
            System.out.println();

            // preparation for next row
            if(row <= n/2){ // first half
                nspaces = nspaces - 1;
                nstars = nstars + 2;
            }else{ // second half
                nspaces = nspaces + 1;
                nstars = nstars - 2;
            }
            row++;
        }

    }
}