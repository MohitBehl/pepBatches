import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int mat[][] = new int[n][n];
        
        for(int i =  0 ; i < n ; i++){
            for(int j = 0  ; j < n ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        
        // diagnol traversal
        
        for(int col = 0 ; col < n ; col++){
            // starting point (0,col)
            for(int x = 0 , y = col ; y < n ; x++ , y++){
                System.out.println(mat[x][y]);
            } 
        }
    }

}