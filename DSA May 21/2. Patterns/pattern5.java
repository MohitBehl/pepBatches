import java.util.*;

public class pattern5 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int row = 1 , nst = 1 , nsp = n/2;
        
        while(row <= n){
            
            // code for each row
            
            for(int i = 1 ; i <= nsp ; i++){
                System.out.print("\t");
            }
            for(int i = 1 ; i <= nst ; i++){
                System.out.print("*\t");
            }
            
            // move to next row 
            System.out.println();
            
            // preparation for next row
            if(row <= n/2){
                nsp = nsp - 1;
                nst = nst + 2;
            }else{
                nsp = nsp + 1;
                nst = nst - 2;
            }
            
            row++;
        }

    }
}