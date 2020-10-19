import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        } 
        spiral(mat);
    }

    public static void spiral(int mat[][]){

        int rmin = 0 , rmax = mat.length-1 , cmin = 0 , cmax = mat[0].length-1;
        int total = mat.length * mat[0].length; 
        int count = 0;
        while(count < total){
            // left wall
            for(int i = rmin ; i <= rmax ; i++){
                System.out.println(mat[i][cmin]);
                count++;
            }
            cmin++;
            // bottom wall
            for(int j = cmin ; j <= cmax; j++){
                System.out.println(mat[rmax][j]);
                count++;
            }
            rmax--;
            // right wall
            for(int i = rmax ; i >= rmin; i--){
                System.out.println(mat[i][cmax]);
                count++;
            }
            cmax--;
            // top wall
            for(int j = cmax ; j >= cmin; j--){
                System.out.println(mat[rmin][j]);
                count++;
            }
            rmin++;
        }

    }
}