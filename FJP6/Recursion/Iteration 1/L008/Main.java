import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int m = scn.nextInt();
        // int[][] arr = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         arr[i][j] = scn.nextInt();
        //     }
        // }
        // floodfill(arr, 0, 0, "",new boolean[n][m]);
        

        // N Queens
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        printNQueens(new int[n][n],"",0);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf,boolean visited[][]) {
        if(sr == maze.length-1 && sc == maze[0].length-1){ // valid
            System.out.println(asf);
            return;
        }
        if(sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 1 || visited[sr][sc]){ // invalid
            return;
        }

        visited[sr][sc] = true; // mark
         
        floodfill(maze,sr-1,sc,asf+"t",visited);
        floodfill(maze,sr,sc-1,asf+"l",visited);
        floodfill(maze,sr+1,sc,asf+"d",visited);
        floodfill(maze,sr,sc+1,asf+"r",visited);
        visited[sr][sc] = false; /// unmark
    }

    public static boolean isSafe(int chess[][],int row,int col){
        for(int i = row-1,j = col ; i >= 0 ; i--){ //  upwards
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i = row-1,j = col-1 ; i >= 0 && j >= 0 ; i--,j--){ // upper left diag
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i = row-1,j = col+1 ; i >= 0 && j < chess[0].length ; i--,j++){ // upper right diag
            if(chess[i][j] == 1){
 
 
 
                return false;
            }
        }

        return true;
    }
    
    public static void printNQueens(int[][] chess, String asf, int row) {
        if(row == chess.length){
            System.out.println(asf+".");
            return;
        }
        for(int col = 0 ; col < chess[0].length ; col++){
            if(isSafe(chess,row,col)){
                chess[row][col] = 1;
                printNQueens(chess,asf+row+"-"+col+", ",row+1);
                chess[row][col] = 0;
            }
        }
    }
}