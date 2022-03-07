import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1 , nspaces = n/2 , nstars = 1;

        while(row <= n){
            // code for each row
                // print spaces
                for(int i = 1 ; i <= nspaces ; i++){
                    if(row == n/2 + 1){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }
                // print stars
                for(int i = 1 ; i <= nstars ; i++){
                    System.out.print("*\t");
                }
            // move to next line
            System.out.println();
            // prepare for next row
            if(row <= n/2){
                nstars = nstars + 1;
            }else{
                nstars = nstars - 1;
            }
            row++;
        }
    }
}