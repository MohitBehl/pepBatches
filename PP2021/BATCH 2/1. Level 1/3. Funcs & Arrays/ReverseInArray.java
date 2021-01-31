import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        for (int val: a) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void reverse(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;

            lo++;
            hi--;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        reverse(a);
        display(a);
    }

}