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

        exitPoint(mat);
    }

    public static void exitPoint(int mat[][]) {
        int nr = mat.length;
        int nc = mat[0].length;

        int dir = 0; // 0 - E , 1 - S , 2 - W , 3 - N
        int i = 0, j = 0; // entry point : (0,0)

        while (true) {

            dir = (dir + mat[i][j]) % 4;

            if (dir == 0) {
                j++;
            } else if (dir == 1) {
                i++;
            } else if (dir == 2) {
                j--;
            } else if (dir == 3) {
                i--;
            }

            if (j == nc) {
                // exited through right wall using east direction
                j = nc - 1;
                break;
            } else if (i == nr) {
                // exited through bottom wall using south direction
                i = nr - 1;
                break;
            } else if (j < 0) {
                // exited through left wall using west direction
                j = 0;
                break;
            } else if (i < 0) {
                // exited through top wall using north direction
                i = 0;
                break;
            }
        }

        System.out.println(i);
        System.out.println(j);
    }

}