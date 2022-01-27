import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int row = 1 , nst = 1 , nsp = n/2 , pval = 1;
        
        while(row <= n){
            
            // code for each row
            
            for(int i = 1 ; i <= nsp ; i++){
                System.out.print("\t");
            }
            int tmp = pval;
            for(int i = 1 ; i <= nst ; i++){
                System.out.print(tmp+"\t");
                if(i <= nst/2){
                    tmp++;
                }else{
                    tmp--;
                }
            }
            
            // move to next row 
            System.out.println();
            
            // preparation for next row
            if(row <= n/2){
                nsp = nsp - 1;
                nst = nst + 2;
                pval = pval + 1;
            }else{
                nsp = nsp + 1;
                nst = nst - 2;
                pval = pval - 1;
            }
            row++;
        }

    }
}