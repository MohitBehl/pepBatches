
import java.util.*;

public class rotateBy90 {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int mat[][] = new int[n][n];
        for(int i = 0 ; i < mat.length ;i++){
            for(int j = 0 ; j < mat[0].length ;j++){
                mat[i][j] = scn.nextInt();
            }
        }

        // transpose of a matrix 
            for(int i = 0 ; i < mat.length ;i++){
                for(int j = i ; j < mat[0].length ;j++){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

        // reverse the matrix row-wise
            for(int r = 0 ; r < mat.length ; r++){
                    int lo = 0;
                    int hi = mat[0].length-1;

                    while(lo < hi){
                        int temp = mat[r][lo];
                        mat[r][lo] = mat[r][hi];
                        mat[r][hi] = temp;

                        lo++;
                        hi--;
                    }
            }
            display(mat);
        scn.close();
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