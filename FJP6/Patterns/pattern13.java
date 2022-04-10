import java.util.*;
public class Main{

    // public static int factorial(int n){
    //     int res = 1;
    //     for(int i = 1 ; i <= n ; i++)
    //     {
    //         res = res * i;
    //     }
    //     return res;
    // }
    // public static int ncr(int n,int r){
    //     int nfact = factorial(n);
    //     int nMrFact = factorial(n-r);
    //     int rFact = factorial(r);

    //     return nfact/(nMrFact*rFact);
    // }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        for(int row = 0 ; row < num ; row++){
            int ncr = 1; // nc0 -> 1
            for(int col = 0 ; col <= row ; col++){
                System.out.print(ncr+"\t");
                int n = row , r = col;

                int ncrp1 = ((n-r) * ncr)/(r+1);
                ncr = ncrp1;
            }
            // line change
            System.out.println();
        }
    }
}