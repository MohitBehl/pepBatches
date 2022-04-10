import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1, nspaces = 1, nstars =(n+1)/2;

        while(row <= n){
            // code for each row

                // nstars
                for(int i = 1 ; i <= nstars ; i++){
                    System.out.print("*\t");
                }
                // nspaces
                for(int i = 1 ; i <= nspaces ; i++){
                    System.out.print("\t");
                }
                // nstars
                for(int i = 1 ; i <= nstars ; i++){
                    System.out.print("*\t");
                }
                
            // line change
            System.out.println();

            // preparation for next row
            if(row <= n/2){
                nstars = nstars - 1;
                nspaces = nspaces + 2;
            }else{
                nstars = nstars + 1;
                nspaces = nspaces - 2;
            }
            row++;
        }
    }
}