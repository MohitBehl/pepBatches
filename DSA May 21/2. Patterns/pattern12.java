import java.util.*;

public class pattern12 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int f = 0;
        int s = 1;
        
        for(int r = 1 ; r <= n ; r++){
            int nst = r;
            for(int i = 1 ; i <= nst ; i++){
                // System.out.print("*\t");
                System.out.print(f+"\t");
                int t = f + s;
                f = s;
                s = t;
            }
            System.out.println();
        }
    }
}