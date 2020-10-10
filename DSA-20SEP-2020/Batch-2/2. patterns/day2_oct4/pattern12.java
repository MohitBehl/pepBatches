import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int f = 0 , s = 1;

        for(int r = 1 ; r <= n ; r++){
            int nst = r;
            for(int i = 1 ; i <= nst ; i++){
                System.out.print(f+"\t");
                int third = f + s;
                f = s;
                s = third;
            } 
            System.out.println();
        }

    }
}