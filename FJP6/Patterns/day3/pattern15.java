import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int row = 1 , nspaces = n/2 , nstars = 1 , num = 1;

        while(row <= n){
            // code for each row
                //1. spaces 
            for(int i = 1 ; i <= nspaces ; i++){
                System.out.print("\t");
            }
                //2. stars
            int tmp = num;
            for(int i = 1 ; i <= nstars ; i++){
                System.out.print(tmp+"\t");
                if(i <= nstars/2){
                    tmp = tmp + 1;
                }else{
                    tmp = tmp - 1;
                }
            }

            // move to new line
            System.out.println();

            // preparation for next row
            if(row <= n/2){ // first half
                nspaces = nspaces - 1;
                nstars = nstars + 2;
                num = num + 1;
            }else{ // second half
                nspaces = nspaces + 1;
                nstars = nstars - 2;
                num = num - 1;
            }
            row++;
        }

    }
}