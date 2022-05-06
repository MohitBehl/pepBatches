import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr, 0, 0, "",new boolean[n][m]);
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
}