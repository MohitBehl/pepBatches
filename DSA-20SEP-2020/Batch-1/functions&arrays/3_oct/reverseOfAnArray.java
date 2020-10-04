import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] arr) {
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.print(arr[idx] + " ");
        }
    }

    public static void reverse(int[] a) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            // swap arr[lo] <--> arr[hi]
            int temp = a[lo];
            a[lo] = a[hi];
            a[hi] = temp;

            lo++;
            hi--;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int size = scn.nextInt();
        int arr[] = new int[size];
        for (int idx = 0; idx < size; idx++) {
            arr[idx] = scn.nextInt();
        }

        reverse(arr);
        display(arr);
    }

}