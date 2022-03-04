import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int count = 1;
        for(int row = 1 ; row <= n ; row++){
            int nst = row;
            for(int i = 1 ; i <= nst ; i++){
                System.out.print(count+"\t");
                count++;
            }   
            System.out.println();
        }

    }
}