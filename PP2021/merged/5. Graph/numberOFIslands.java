import java.io.*;
import java.util.*;

public class numberOFIslands {
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

      System.out.println(numberOfIsland(arr));
   }
   
   public static int numberOfIsland(int arr[][]){
       int nr = arr.length , nc = arr[0].length;
       boolean visited[][] = new boolean[nr][nc];
       int count = 0;
       
       for(int i = 0 ; i < nr ; i++){
           for(int j = 0 ; j < nc ; j++){
                if(arr[i][j] == 0 && visited[i][j] == false){
                    gcc(arr,visited,i,j);
                    count++;
                }    
           }
       }
       return count;
   }
   
   public static void gcc (int arr[][],boolean visited[][],int r ,int c){
        if(r < 0 || c <0 || r>=arr.length || c>=arr[0].length || arr[r][c] == 1 || visited[r][c] == true){
            return;
        }
        visited[r][c] = true;
        gcc(arr,visited,r-1,c);// north
        gcc(arr,visited,r,c+1);// east
        gcc(arr,visited,r,c-1);// west
        gcc(arr,visited,r+1,c);// south
        // do nothing while returning
   }

}