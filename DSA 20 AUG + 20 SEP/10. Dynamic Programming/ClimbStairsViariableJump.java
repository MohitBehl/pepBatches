import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int moves[] = new int[n];
        for (int i = 0; i < n; i++) {
            moves[i] = scn.nextInt();
        }

        System.out.println(CBVairableJumpDpT(n, moves));

    }
    // public static int CS(int moves[],int idx,int dest){

    // }
    public static int CBVairableJumpDpT(int n, int moves[]) {
        int qb[] = new int[n + 1];

        for (int i = n; i >= 0; i--) {
            if (i == n) {
                // dest
                qb[i] = 1;
            } else {
                int maxJump = moves[i];

                for (int len = 1; len <= maxJump && i + len <= n; len++) {
                    qb[i] += qb[i + len];
                }
            }
        }
        return qb[0];
    }

}