import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int nsp = n/2;
        int nst = 1;
        int row = 1;
        
        while(row <= n){
            // print spaces
            for(int i = 1 ; i <= nsp ; i++){
                if(row == (n/2) +1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            // print stars
            for(int i = 1 ; i <= nst ; i++){
                System.out.print("*\t");
            }
            
            System.out.println();
            
            if(row <= n/2){
                nst++;
            }else{
                nst--;
            }
            
            row++;
        }

    }
}