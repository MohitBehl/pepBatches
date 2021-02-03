import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int nr1 = scn.nextInt();
        int nc1 = scn.nextInt();
        int mat1[][] = new int[nr1][nc1];
        for (int i = 0; i < nr1; i++) {
            for (int j = 0; j < nc1; j++) {
                mat1[i][j] = scn.nextInt();
            }
        }

        int nr2 = scn.nextInt();
        int nc2 = scn.nextInt();
        int mat2[][] = new int[nr2][nc2];
        for (int i = 0; i < nr2; i++) {
            for (int j = 0; j < nc2; j++) {
                mat2[i][j] = scn.nextInt();
            }
        }

        int res[][] = multiply(mat1, mat2);

        if (res == null) {
            System.out.println("Invalid input");
        } else {
            display(res);
        }

    }

    public static void display(int mat[][]) {
        for (int oned[]: mat) {
            for (int ele: oned) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiply(int mat1[][], int mat2[][]) {
        int nr1 = mat1.length, nc1 = mat1[0].length;
        int nr2 = mat2.length, nc2 = mat2[0].length;


        if (nc1 == nr2) {
            // multiplication possible
            int res[][] = new int[nr1][nc2];

            for (int r = 0; r < nr1; r++) {
                for (int c = 0; c < nc2; c++) {

                    for (int k = 0; k < nc1; k++) {
                        res[r][c] += (mat1[r][k] * mat2[k][c]);
                    }
                }
            }

            return res;
        } else {
            // matrix multiplication is not valid
            return null;
        }
    }

}