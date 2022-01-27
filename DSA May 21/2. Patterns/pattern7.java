import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n ; c++){
                if(r == c){
                    System.out.print("*	");
                }else{
                    System.out.print("	");
                }
            }
            
            System.out.println();
        }

    }
}