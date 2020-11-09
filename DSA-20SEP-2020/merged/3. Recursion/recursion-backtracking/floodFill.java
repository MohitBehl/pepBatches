import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int nrow = scn.nextInt();
        int ncol = scn.nextInt();
        int maze[][] = new int[nrow][ncol];

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                maze[i][j] = scn.nextInt();
            }
        }

        floodfill(maze, 0, 0, "", new boolean[nrow][ncol]);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited) {

        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == 1 || visited[row][col]) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            // destination reached
            System.out.println(psf);
            return;
        }


        visited[row][col] = true; // mark visited

        // top
        floodfill(maze,row-1,col,psf+"t",visited);
        // left
        floodfill(maze,row,col-1,psf+"l",visited);
        // down
        floodfill(maze,row+1,col,psf+"d",visited);
        // right
        floodfill(maze,row,col+1,psf+"r",visited);

        visited[row][col] = false; // mark unvisited
    }
}