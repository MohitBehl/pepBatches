import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int mat[][] = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        transpose(mat);
        reverseRowWise(mat);
        display(mat);
    }
    public static void transpose(int mat[][]){
        // logic for transposing
        int n = mat.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
    }
    
    public static void reverseRowWise(int mat[][]){
        // logic for reversing each row
        int n = mat.length;
        for(int r = 0 ; r < n ; r++){
            int lo = 0 , hi = n-1;
            
            while(lo < hi){
               int tmp = mat[r][lo];
               mat[r][lo] = mat[r][hi];
               mat[r][hi] = tmp;
               
               lo++;
               hi--;
            }
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}