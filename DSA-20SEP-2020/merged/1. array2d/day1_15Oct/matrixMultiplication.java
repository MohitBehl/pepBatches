import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        
        int nr1 = scn.nextInt();
        int nc1 = scn.nextInt();
        int mat1[][] = new int[nr1][nc1];
        for(int i = 0 ; i < mat1.length ; i++){
            for(int j = 0 ; j < mat1[0].length ; j++){
                mat1[i][j] = scn.nextInt();
            }
        }
        int nr2 = scn.nextInt();
        int nc2 = scn.nextInt();
        int mat2[][] = new int[nr2][nc2];
        
        for(int i = 0 ; i < mat2.length ; i++){
            for(int j = 0 ; j < mat2[0].length ; j++){
                mat2[i][j] = scn.nextInt();
            }
        }
        
        if(nc1 == nr2){
            // multiplication possible
            int res[][] = multiply(mat1,mat2);
            
            for(int i = 0 ; i < res.length ; i++){
                for(int j = 0 ; j < res[0].length ; j++){
                    System.out.print(res[i][j]+" ");
                }
                System.out.println();
            }
            
        }else{
            // multiplication impossible
            System.out.println("Invalid input");
        }
    }
    
    public static int[][] multiply(int mat1[][] ,int mat2[][]){
        // code for multiplying mat1 & mat2
        int nr1 = mat1.length , nc1 = mat1[0].length;
        int nr2 = mat2.length , nc2 = mat2[0].length;
        
        int res[][] = new int[nr1][nc2];
        
        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0 ; j < res[0].length ; j++){
                
                for(int k = 0 ; k < nc1 ; k++){
                    res[i][j] += (mat1[i][k] * mat2[k][j]);     
                }
                
            }
        }
        return res;
    }
}