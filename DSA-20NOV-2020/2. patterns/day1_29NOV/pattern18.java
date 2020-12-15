import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1, nsp = 0, nst = n;

        while (row <= n) {
            //  spaces 
            for (int i = 1; i <= nsp; i++) {
                System.out.print("\t");
            }
            // stars
            for (int i = 1; i <= nst; i++) {
                if((row > 1 && row < (n/2) + 1)){
                    if((i == 1 || i == nst)){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }else{
                    System.out.print("*\t");
                }
            }
            
            // new line
            System.out.println();
            
            // preparation for next row
            
            if(row <= n/2){
                nsp++;
                nst -= 2;
            }else{
                nsp--;
                nst += 2;
            }
            
            row++;
        }

    }
}