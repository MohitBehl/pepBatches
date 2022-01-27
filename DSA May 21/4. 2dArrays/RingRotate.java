import java.io.*;
import java.util.*;

public class RingRotate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
    
        int mat[][] = new int[nr][nc];
    
        for (int i = 0 ; i < nr; i++) {
          for (int j = 0 ; j < nc ; j++) {
            mat[i][j] = scn.nextInt();
          }
        }
    
        int shellNo = scn.nextInt();
        int k = scn.nextInt();
        
        ringRotate(mat,shellNo,k);
        display(mat);
      }
      public static void ringRotate(int mat[][], int shellNo, int k) {
        int oned[] = getShellElements(mat, shellNo);
        rotate(oned, k);
        putShellElements(mat, shellNo, oned);
      }
    
      public static int[] getShellElements(int mat[][], int shellNo) {
        int nr = mat.length, nc = mat[0].length;
        int rmin = shellNo - 1, cmin = shellNo - 1, rmax = nr - shellNo, cmax = nc - shellNo;
        int n = 2 * (rmax - rmin + cmax - cmin);
    
    
        int oned[] = new int[n];
        int idx = 0;
        // leftWall
        for (int r = rmin, c = cmin ; r <= rmax; r++) {
          oned[idx] = mat[r][c];
          idx++;
        }
    
        // BottomWall
        for (int r = rmax, c = cmin + 1 ; c <= cmax; c++) {
          oned[idx] = mat[r][c];
          idx++;
        }
    
        // RightWall
        for (int r = rmax - 1, c = cmax ; r >= rmin; r--) {
          oned[idx] = mat[r][c];
          idx++;
        }
    
        // TopWall
        for (int r = rmin, c = cmax - 1 ; c >= cmin + 1; c--) {
          oned[idx] = mat[r][c];
          idx++;
        }
        
        return oned;
      }
    
      public static void putShellElements(int mat[][], int shellNo, int oned[]) {
        int nr = mat.length, nc = mat[0].length;
        int rmin = shellNo - 1, cmin = shellNo - 1, rmax = nr - shellNo, cmax = nc - shellNo;
    
    
        int idx = 0;
        // leftWall
        for (int r = rmin, c = cmin ; r <= rmax; r++) {
          mat[r][c] = oned[idx];
          idx++;
        }
    
        // BottomWall
        for (int r = rmax, c = cmin + 1 ; c <= cmax; c++) {
          mat[r][c] = oned[idx];
          idx++;
        }
    
        // RightWall
        for (int r = rmax - 1, c = cmax ; r >= rmin; r--) {
          mat[r][c] = oned[idx];
          idx++;
        }
    
        // TopWall
        for (int r = rmin, c = cmax - 1 ; c >= cmin + 1; c--) {
          mat[r][c] = oned[idx];
          idx++;
        }
      }
    
      public static void rotate(int[] a, int k) {
        k = k % a.length;
    
        if (k < 0) {
          k = k + a.length;
        }
    
        reverse(a, 0, a.length - k - 1); // p1
        reverse(a, a.length - k, a.length - 1); // p2
        reverse(a, 0, a.length - 1); // a
      }
    
      public static void reverse(int arr[], int lo, int hi) {
        while (lo < hi) {
          int tmp = arr[lo];
          arr[lo] = arr[hi];
          arr[hi] = tmp;
    
          lo++;
          hi--;
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
