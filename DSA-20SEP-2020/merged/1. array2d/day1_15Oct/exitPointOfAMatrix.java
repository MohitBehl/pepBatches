import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int mat[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        exitPoint(mat);    
    }
    
    public static void exitPoint(int mat[][]){
        // 0 --> E , 1 --> S , 2 --> W , 3 --> N
        int row = 0 , col = 0 , dir = 0;
        while(true){
            dir = (dir + mat[row][col])%4;
            if(dir == 0){
                // move east
                col++;
            }else if(dir == 1){
                // move south
                row++;
            }else if(dir == 2){
                // move west
                col--;
            }else if(dir == 3){
                // move north
                row--;
            }
            
            if(col == mat[0].length){
                // exited through east wall
                col--; 
                break;
            }else if(row == -1){
                // exited through north wall
                row++;
                break;
            }else if(col == -1){
                // exited through left wall
                col++;
                break;
            }else if(row == mat.length){
                // exited through south wall
                row--;
                break;
            }
        }
        System.out.println(row);
        System.out.println(col);
    }
}

















