import java.io.*;
import java.util.*;

public class Main{
    public static void input(int mat[][], Scanner scn){
      for(int r = 0 ; r < mat.length ; r++){
        for(int c = 0 ; c < mat[0].length ; c++){
          mat[r][c] = scn.nextInt();
        }
      }
    }
    public static void display(int mat[][]){
      for(int r = 0 ; r < mat.length ; r++){
        for(int c = 0 ; c < mat[0].length ; c++){
          System.out.print(mat[r][c]+" ");
        }
        System.out.println();
      }
    }
    public static int[][] matrixMultiplication(int mat1[][],int mat2[][]){
        int res[][] = new int[][];
        // main logic
        return res;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int nr1 = scn.nextInt();
        int nc1 = scn.nextInt();
        int mat1[][] = new int[nr1][nc1];
        input(mat1,scn);

        int nr2 = scn.nextInt();
        int nc2 = scn.nextInt();
        int mat2[][] = new int[nr2][nc2];
        input(mat2,scn);

        int res[][] = matrixMultiplication(mat1,mat2);
        display(res);
    }

}