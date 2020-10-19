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
        int shell = scn.nextInt();
        int k = scn.nextInt();
        shellRotate(mat, shell, k);
        display(mat);
    }

    public static void shellRotate(int mat[][], int shell, int k) {
        // step 1 : extract elements from mat.
        int arr[] = fill1D(mat, shell);

        // step 2 : rotate 1Darray by k
        rotate(arr, k);

        // step 3 : fill mat with the elements of rotated array
        fill2D(mat, shell, arr);
    }

    public static int[] fill1D(int mat[][], int shell) {
        int nrows = mat.length, ncols = mat[0].length;
        int rmin = shell - 1, cmin = shell - 1, rmax = nrows - shell, cmax = ncols - shell;
        int n = 2 * (cmax - cmin + rmax - rmin); // number of elements of shell 
        int arr[] = new int[n];
        int idx = 0;
        // left wall
        for (int i = rmin; i <= rmax; i++) {
            // [i][cmin]
            arr[idx] = mat[i][cmin];
            idx++;
        }
        cmin++;
        // bottom wall
        for (int j = cmin; j <= cmax; j++) {
            // [rmax][j]
            arr[idx] = mat[rmax][j];
            idx++;
        }
        rmax--;
        // right wall
        for (int i = rmax; i >= rmin; i--) {
            // [i][cmax]
            arr[idx] = mat[i][cmax];
            idx++;
        }
        cmax--;
        // top wall
        for (int j = cmax; j >= cmin; j--) {
            // [rmin][j]
            arr[idx] = mat[rmin][j];
            idx++;
        }
        return arr;
    }

    public static void fill2D(int mat[][], int shell, int rotatedArr[]) {
        int nrows = mat.length, ncols = mat[0].length;
        int rmin = shell - 1, cmin = shell - 1, rmax = nrows - shell, cmax = ncols - shell;
        int idx = 0;
        // left wall
        for (int i = rmin; i <= rmax; i++) {
            // [i][cmin]
            mat[i][cmin] = rotatedArr[idx];
            idx++;
        }
        cmin++;
        // bottom wall
        for (int j = cmin; j <= cmax; j++) {
            // [rmax][j]
            mat[rmax][j] = rotatedArr[idx];
            idx++;
        }
        rmax--;
        // right wall
        for (int i = rmax; i >= rmin; i--) {
            // [i][cmax]
            mat[i][cmax] = rotatedArr[idx];
            idx++;
        }
        cmax--;
        // top wall
        for (int j = cmax; j >= cmin; j--) {
            // [rmin][j]
            mat[rmin][j] = rotatedArr[idx];
            idx++;
        }
    }

    public static void rotate(int[] a, int k) {
        // write your code here

        // true rotation number
        k = k % a.length;

        // -ve case 
        if (k < 0) {
            k = k + a.length;
        }

        // a = part1 + part2
        // 1. reverse last k elements --> reverse part2
        reverse(a, a.length - k, a.length - 1);
        // 2. reverse first n-k elements --> reverse part1
        reverse(a, 0, a.length - k - 1);
        // 3. reverse all n elements
        reverse(a, 0, a.length - 1);
    }
    public static void reverse(int a[], int li, int ri) {
        while (li < ri) {
            int temp = a[li];
            a[li] = a[ri];
            a[ri] = temp;

            li++;
            ri--;
        }
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