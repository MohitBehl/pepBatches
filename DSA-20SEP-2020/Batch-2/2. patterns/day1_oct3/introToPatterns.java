import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        // // line
        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print("*\t");
        // }
        
        for(int r = 1 ; r <= n ; r++){
            
            // code for each row 
            for(int i = 1 ; i <= n ; i++){
                System.out.print("*\t");
            }
            
            // move to next line 
            System.out.println();
        }
        
      
    }
}