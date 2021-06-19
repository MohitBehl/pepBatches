import java.io.*;
import java.util.*;

public class FloodFill {

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
    
    
    public static void floodfill(int[][] maze, int sr, int sc, String asf,boolean [][]visited) {
        if(sr == maze.length-1 && sc == maze[0].length-1){
            System.out.println(asf);
            return;
        }
        if(sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 1 || visited[sr][sc]){
            return;
        }
        visited[sr][sc] = true;
        floodfill(maze,sr-1,sc,asf+"t",visited);//top
        floodfill(maze,sr,sc-1,asf+"l",visited);//left
        floodfill(maze,sr+1,sc,asf+"d",visited);//down
        floodfill(maze,sr,sc+1,asf+"r",visited);//right
        visited[sr][sc] = false;
    }
}
