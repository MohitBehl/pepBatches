import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = nr;

        int mat[][] = new int[nr][nc];

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        int ele = scn.nextInt();

        search(mat, ele);
    }

    public static void search(int mat[][], int ele) {
        int nr = mat.length;
        int nc = nr;
        int i = 0, j = nc - 1;

        while (i <= nr - 1 && j >= 0) {
            int val = mat[i][j];

            if (ele < val) {
                // smaller
                j--;
            } else if (ele > val) {
                // larger
                i++;
            } else {
                // ele found
                System.out.println(i + "\n" + j);
                return;
                // return true;
            }
        }
        System.out.println("Not Found");
    }

}