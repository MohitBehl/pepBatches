import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    
    int row = 1 , nsp = (2*n) - 3 , nst = 1;
    
    while(row <= n){
        // code for each row --> left part
            int lv = 1;
            // print stars
                for(int i = 1 ; i <= nst ; i++){
                    System.out.print(lv+"\t");
                    lv++;
                }
                
            // print spaces
                for(int i = 1 ; i <= nsp ; i++){
                    System.out.print("\t");
                }
            int rv = row;    
            if(row == n){
                // special code for last row
                nst = n-1;
                rv = n-1;
            }
            // print stars --> right part
                for(int i = 1 ; i <= nst ; i++){
                    System.out.print(rv+"\t");
                    rv--;
                }
        // move to new line 
            System.out.println();
            
        // preparation for next row
        nst++;
        nsp -= 2;
        row++;
    }

 }
}