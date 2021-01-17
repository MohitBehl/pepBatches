import java.io.*;
import java.util.*;

public class Main {
    public static int numberOfIslands(int arr[][]){
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if(arr[i][j] == 0 && visited[i][j] == false){
                    count++;
                    floodFill(arr,visited,i,j);
                } 
            }
        }      
        return count;
    }
    
    public static void floodFill(int arr[][],boolean visited[][],int i,int j){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true){
            return;
        }
        
        visited[i][j] = true;
        floodFill(arr,visited,i-1,j);// north
        floodFill(arr,visited,i,j+1);// east
        floodFill(arr,visited,i,j-1);// west
        floodFill(arr,visited,i+1,j);// south
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        System.out.println(numberOfIslands(arr));
    }

}
