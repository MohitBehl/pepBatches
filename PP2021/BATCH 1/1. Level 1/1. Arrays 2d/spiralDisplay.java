import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int mat[][] = new int[nr][nc];

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        spiralDisplay(mat);
    }

    public static void spiralDisplay(int mat[][]) {
        int nr = mat.length;
        int nc = mat[0].length;

        int rmax = nr - 1, rmin = 0, cmax = nc - 1, cmin = 0;

        int count = 0;
        while (count < (nr * nc)) {

            // left wall : top -> bottom
            for (int i = rmin, j = cmin; i <= rmax && count < (nr * nc); i++) {
                System.out.println(mat[i][j]);
                count++;
            }
            cmin++;

            // bottom wall : left -> right
            for (int i = rmax, j = cmin; j <= cmax && count < (nr * nc); j++) {
                System.out.println(mat[i][j]);
                count++;
            }
            rmax--;

            // right wall : bottom -> top
            for (int i = rmax, j = cmax; i >= rmin && count < (nr * nc); i--) {
                System.out.println(mat[i][j]);
                count++;
            }
            cmax--;

            // top wall : right -> left
            for (int i = rmin, j = cmax; j >= cmin && count < (nr * nc); j--) {
                System.out.println(mat[i][j]);
                count++;
            }
            rmin++;
        }
    }

}