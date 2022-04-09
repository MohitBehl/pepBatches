import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        // // line 
        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print("*");
        // }

        // square
        for(int r = 1 ; r <= n ; r++){
            for(int c = 1 ; c <= n ; c++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}