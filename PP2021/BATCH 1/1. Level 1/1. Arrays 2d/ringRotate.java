import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt(), nc = scn.nextInt();
        int mat[][] = new int[nr][nc];

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        int shell = scn.nextInt();
        int k = scn.nextInt();

        shellRotate(mat, shell, k);
        display(mat);
    }

    public static void shellRotate(int mat[][], int shell, int k) {
        // fill shell elements to a oneD array
        int oned[] = fill1d(mat, shell);
        rotate(oned, k);
        fill2d(mat, shell, oned);
    }

    public static int[] fill1d(int mat[][], int shell) {
        int nr = mat.length;
        int nc = mat[0].length;
        int rmin = shell - 1, cmin = shell - 1, rmax = nr - shell, cmax = nc - shell;
        int total = 2 * (rmax - rmin + cmax - cmin);

        int oned[] = new int[total];
        int idx = 0;
        // left wall : top -> bottom
        for (int i = rmin, j = cmin; i <= rmax; i++) {
            oned[idx] = mat[i][j];
            idx++;
        }
        cmin++;

        // bottom wall : left -> right
        for (int i = rmax, j = cmin; j <= cmax; j++) {
            oned[idx] = mat[i][j];
            idx++;
        }
        rmax--;

        // right wall : bottom -> top
        for (int i = rmax, j = cmax; i >= rmin; i--) {
            oned[idx] = mat[i][j];
            idx++;
        }
        cmax--;

        // top wall : right -> left
        for (int i = rmin, j = cmax; j >= cmin; j--) {
            oned[idx] = mat[i][j];
            idx++;
        }
        rmin++;
        
        return oned;
    }
    public static void fill2d(int[][] mat, int shell, int[] oned) {
        int nr = mat.length;
        int nc = mat[0].length;
        int rmin = shell - 1, cmin = shell - 1, rmax = nr - shell, cmax = nc - shell;
        
        int idx = 0;
        // left wall : top -> bottom
        for (int i = rmin, j = cmin; i <= rmax; i++) {
            mat[i][j]  = oned[idx];
            idx++;
        }
        cmin++;

        // bottom wall : left -> right
        for (int i = rmax, j = cmin; j <= cmax; j++) {
            mat[i][j]  = oned[idx];
            idx++;
        }
        rmax--;

        // right wall : bottom -> top
        for (int i = rmax, j = cmax; i >= rmin; i--) {
            mat[i][j]  = oned[idx];
            idx++;
        }
        cmax--;

        // top wall : right -> left
        for (int i = rmin, j = cmax; j >= cmin; j--) {
            mat[i][j]  = oned[idx];
            idx++;
        }
        rmin++;
    }
    public static void reverse(int[] a, int li, int ri) {
        while (li < ri) {
            int temp = a[li];
            a[li] = a[ri];
            a[ri] = temp;

            li++;
            ri--;
        }
    }

    public static void rotate(int[] a, int k) {
        k = k % a.length;
        if (k < 0) {
            k += a.length;
        }

        reverse(a, 0, a.length - k - 1);
        reverse(a, a.length - k, a.length - 1);
        reverse(a, 0, a.length - 1);
    }
    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}