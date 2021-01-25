import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int mat[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        int ans = saddlePoint(mat);
        if (ans == Integer.MAX_VALUE) {
            System.out.println("Invalid input");
        } else {
            System.out.println(ans);
        }

    }
    //saddlePoint(mat); 
    // returns Integer.MAX_VALUE if saddle point doesn't exists otherwise returns val;
    public static int saddlePoint(int mat[][]) {
        int n = mat.length;

        for (int r = 0; r < n; r++) {
            // minimum of the row
            int rowMinVal = Integer.MAX_VALUE;
            int minCol = -1;
            for (int c = 0; c < n; c++) {
                if (rowMinVal > mat[r][c]) {
                    rowMinVal = mat[r][c];
                    minCol = c;
                }
            }

            boolean flag = true; // assume rowMinVal is also maximum in it's column

            for (int i = 0, j = minCol; i < n; i++) {
                if (mat[i][j] > rowMinVal) {
                    // assumption voilated
                    flag = false;
                    break;
                }
            }

            if (flag == true) {
                // assumption is correct : saddle point
                return rowMinVal;
            }
        }
        return Integer.MAX_VALUE;
    }
}