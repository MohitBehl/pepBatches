import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int r = 1 ; r <= n ; r++){
            int nstars = r;
            int nspaces = n-r;
            // spaces
            for(int i = 1 ; i <= nspaces ; i++){
                System.out.print("\t");
            }
            // stars
            for(int i = 1 ; i <= nstars ; i++){
                System.out.print("*\t");
            }
            // line change
            System.out.println();
        }

    }
}