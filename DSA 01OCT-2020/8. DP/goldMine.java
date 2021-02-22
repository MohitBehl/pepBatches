import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);\

        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int cost[][] = new int[nr][nc];

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                cost[i][j] = scn.nextInt();
            }
        }

        System.out.println(goldMine(cost));
    }

    public static int goldMine(int cost[][]) {
        int nr = cost.length, nc = cost[0].length;
        int dp[][] = new int[nr][nc];

        for (int c = nc - 1; c >= 0; c--) {
            for (int r = 0; r < nr; r++) {
                if (c == nc - 1) {
                    dp[r][c] = cost[r][c];
                } else {
                    int valA = (r == 0) ? Integer.MIN_VALUE : dp[r - 1][c + 1]; // dir  A
                    int valB = dp[r][c + 1]; // dir B
                    int valC = (r == nr - 1) ? Integer.MIN_VALUE : dp[r + 1][c + 1]; // dir C

                    dp[r][c] = Math.max(valA, Math.max(valB, valC)) + cost[r][c];
                }
            }
        }

        int maxGold = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < nr; i++) {
            if (dp[i][j] > maxGold) {
                maxGold = dp[i][j];
            }
        }

        return maxGold;
    }
}