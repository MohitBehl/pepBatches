import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printNQueens(new int[n][n],"",0);
    }
    
    public static boolean isSafe(int chess[][] , int row , int col){
        // vertical-up check
        for(int tmp = row-1 ; tmp >= 0 ;tmp--){
            if(chess[tmp][col] == 1){
                // unsafe
                return false;
            }
        }
        
        // diagonal left check
        for(int i = row-1,j = col-1 ; i >= 0 && j >= 0 ; i--,j--){
            if(chess[i][j] == 1){
                // unsafe
                return false;
            }
        }
        
        // diagonal right check
        for(int i = row-1,j = col+1 ; i >= 0 && j < chess[0].length ; i--,j++){
            if(chess[i][j] == 1){
                // unsafe
                return false;
            }
        }
        
        // implication : pos is safe 
        return true;
    }

    public static void printNQueens(int[][] chess, String asf, int row) {
        if(row == chess.length){
            System.out.println(asf+".");
            return;
        }
        for(int col = 0 ; col < chess[0].length ; col++){
            if(isSafe(chess,row,col)){
                chess[row][col] = 1; //mark visited 
                
                printNQueens(chess,asf+row+"-"+col+", " ,row+1);
                
                chess[row][col] = 0; // mark unvisited
            }
        }
    }
}