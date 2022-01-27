import java.util.Scanner;

public class pattern20 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        for(int r = 0; r < n ;r++){
            for(int c = 0 ; c < n ;c++){
                if(c == 0 || c == n-1){
                    System.out.print("*\t");
                }else if(r >= n/2 && (r == c || r + c == n-1)){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }
}
