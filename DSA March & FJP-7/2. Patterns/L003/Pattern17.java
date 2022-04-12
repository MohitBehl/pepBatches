import java.util.*;
class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1, nspaces = n/2 , nstars = 1;
        while(row <= n){
            // code for each row
            for(int i = 1 ; i <= nspaces ; i++){
                if(row == n/2+1){
                    System.out.print("*\t");    
                }else{
                    System.out.print("\t");
                }
            }
            for(int i = 1 ; i <= nstars ; i++){
                System.out.print("*\t");
            }
            // line change
            System.out.println();
            // preparation for next row
            if(row <= n/2){
                nstars++;
            }else{
                nstars--;
            }
            row++;
        }

    }
}