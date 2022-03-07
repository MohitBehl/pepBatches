import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nstars = n/2 + 1 , row = 1 , nspaces = 1;

        while(row <= n){
            // do as homework
            // code for each row
                
                // 1. print stars
                // 2. print space
                // 3. print stars

            // move to next Line
            System.out.println();

            // preparation for next row
            if(row <= n/2){
                // first half
                nstars = nstars - 1;
                nspaces = nspaces + 2;
            }else{
                // second half
                nstars = nstars + 1;
                nspaces - 2;
            }

            row++;
        }

    }
}