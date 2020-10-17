import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int mat[][] = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int  j = 0 ; j < n ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        
        transpose(mat);
        
        reverse(mat);
        
        display(mat);
    }
    
    public static void reverse(int mat[][]){
        // reverse(row-wise)
        
        int n = mat.length;
        for(int row = 0 ; row < n ; row++){
            int lo = 0;
            int hi = n-1;
            
            while(lo < hi){
                int temp = mat[row][lo];
                mat[row][lo] = mat[row][hi];
                mat[row][hi] = temp;
                
                lo++;
                hi--;
            }
        }
    }
    public static void transpose(int mat[][]){
        // transpose of a matrix
        int n = mat.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                // swap ->[i][j] <-->[j][i]
                
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
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