import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        printStairPaths_proActive(n, "");
    }

    public static void printStairPaths(int n, String psf) {
        if (n < 0) {
            // invalid place : when length of step is more than stairs-to-climb.
            return;
        }
        if (n == 0) {
            System.out.println(psf);
            return;
        }
        printStairPaths(n - 1, psf + 1);
        printStairPaths(n - 2, psf + 2);
        printStairPaths(n - 3, psf + 3);
    }

    public static void printStairPaths_proActive(int n, String psf) {
        if (n == 0) {
            System.out.println(psf);
            return;
        }
        if (n >= 1)
            printStairPaths_proActive(n - 1, psf + 1);
        if (n >= 2)
            printStairPaths_proActive(n - 2, psf + 2);
        if (n >= 3)
            printStairPaths_proActive(n - 3, psf + 3);
    }


}