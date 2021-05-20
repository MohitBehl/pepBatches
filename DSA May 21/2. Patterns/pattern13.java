import java.util.Scanner;

public class pattern13 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int inp = scn.nextInt();
        
        for(int n = 0 ; n < inp ; n++){
            int nCr = 1;
            for(int r = 0 ; r <= n ; r++){
                System.out.print(nCr+"\t");
                nCr = (n-r)*nCr/(r+1);
            }
            System.out.println();
        }
        
        
        // for(int n = 0 ; n < inp ; n++){
        //     for(int r = 0 ; r <= n ; r++){
                
        //         int nFact = 1;
        //         for(int k = 1 ; k <= n ; k++){
        //             nFact = nFact * k;
        //         }
                
        //         int rFact = 1;
        //         for(int k = 1 ; k <= r ; k++){
        //             rFact = rFact * k;
        //         }
                
        //         int nMrFact = 1;
        //         for(int k = 1 ; k <= n-r ; k++){
        //             nMrFact = nMrFact * k;
        //         }
                
        //         int nCr = nFact / (nMrFact*rFact);
        //         System.out.print(nCr+"\t");
        //     }
        //     System.out.println();
        // }

    }
}
