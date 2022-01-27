import java.util.*;

public class pattern18{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    int row  = 1 , nsp = 0 , nst = n;
    while(row <= n){
        // code for each row
        for(int i = 1 ; i <= nsp ; i++){
            System.out.print("\t");
        }
        for(int i = 1 ; i <= nst ; i++){
            if(row > 1 && row <= n/2){
                if(i == 1 || i == nst){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }else{
                System.out.print("*\t");
            }
        }
        
        // move to next line
        System.out.println();
        
        // preparation for next row
        if(row <= n/2){
            nst = nst - 2;
            nsp = nsp + 1;
        }else{
            nst = nst + 2;
            nsp = nsp - 1;
        }
        row++;
    }
 }
}