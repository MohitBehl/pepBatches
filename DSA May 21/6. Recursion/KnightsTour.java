import java.io.*;
import java.util.*;

public class KnightsTour {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int r = scn.nextInt() , c = scn.nextInt();
        
        printKnightsTour(new int[n][n],r,c,1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int um) {
        if(r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] != 0){
            return;
        }
        if(um == chess.length * chess[0].length){
            chess[r][c] = um;
            display(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = um;
        printKnightsTour(chess,r-2,c+1,um+1);
        printKnightsTour(chess,r-1,c+2,um+1);
        printKnightsTour(chess,r+1,c+2,um+1);
        printKnightsTour(chess,r+2,c+1,um+1);
        printKnightsTour(chess,r+2,c-1,um+1);
        printKnightsTour(chess,r+1,c-2,um+1);
        printKnightsTour(chess,r-1,c-2,um+1);
        printKnightsTour(chess,r-2,c-1,um+1);
        chess[r][c] = 0;
    }

    public static void display(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}