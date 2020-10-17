import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      
        // System.out.println(Integer.MAX_VALUE);  
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int mat[][] = new int[n][n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        
        // saddle point ?
        
        for(int row = 0 ; row < n ; row++){
            
            int minValInRow = Integer.MAX_VALUE; //+infinity
            int minIdx = -1; // calumn at which minimum value was found
            // minimum of row
            for(int col = 0 ;  col < n ; col++){
                if(minValInRow > mat[row][col]){
                    minValInRow = mat[row][col];
                    minIdx = col;
                }
            }
            
            // check : minValue of row is maximum element of it's column or not?
            boolean isMax = true; // assumption`
            for(int k = 0 ; k < n ; k++){
                if(minValInRow < mat[k][minIdx]){
                    // my initial assumption was wrong :-> minValInRow isn't largest value in column
                    isMax = false;
                    break;
                }
            }
            
            if(isMax){
                // saddle point found
                System.out.println(minValInRow);
                return;
            }
        }
        // implication :no saddle point was found
        System.out.println("Invalid input");
    }

}