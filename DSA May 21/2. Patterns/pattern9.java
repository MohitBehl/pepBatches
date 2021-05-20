import java.util.*;

public class pattern9 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        
        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n ; c++){
                if(r == c || (r+c) == n-1){
                    System.out.print("*	");
                }else{
                    System.out.print("	");
                }
            }
            System.out.println();
        }
    }
}