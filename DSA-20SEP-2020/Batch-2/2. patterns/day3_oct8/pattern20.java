import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for(int r = 1; r <= n ;r++){
            for(int c = 1; c <= n ;c++){
                if(c == 1 || c == n){
                    // left wall or right wall
                    System.out.print("*\t");
                }else if((r == c || r+c == n+1) && r > n/2){
                    // diagonals
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }
}