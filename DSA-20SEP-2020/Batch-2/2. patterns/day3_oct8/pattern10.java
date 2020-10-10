import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1 , nsp = n/2 , nst = 1;

        while(row <= n){
            // code for each row 
            // print spaces 
            for(int i = 1 ; i <= nsp ;i++){
                System.out.print("\t");
            }
            // print stars
            for(int i = 1 ; i <= nst ;i++){
                if(i == 1 || i == nst){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            
            // new line 
            System.out.println();

            // preparation for next row 

            if(row <= n/2){
                nsp--;
                nst+=2;
            }else{
                nst-=2;
                nsp++;
            }

            row++;
        }

    }
}