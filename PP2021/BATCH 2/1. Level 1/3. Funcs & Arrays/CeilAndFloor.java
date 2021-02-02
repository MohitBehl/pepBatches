import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();

        ceilAndFloor2(arr, x);
    }

    public static void ceilAndFloor2(int arr[], int x) {
        int lo = 0, hi = arr.length - 1, ceil = Integer.MAX_VALUE, floor = Integer.MIN_VALUE;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == x) {
                floor = ceil = arr[mid];
                break;
            } else if (x > arr[mid]) {
                lo = mid + 1;
                floor = arr[mid];
            } else {
                //(x < arr[mid])
                hi = mid - 1;
                ceil = arr[mid];
            }
        }

        System.out.println(ceil + "\n" + floor);
    }
    public static void ceilAndFloor1(int arr[], int x) {
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        for (int val: arr) {
            if (val > x) {
                // larger : ceil
                if (val < ceil) {
                    // minimum among larger
                    ceil = val;
                }
            } else if (val < x) {
                // smaller : floor
                if (val > floor) {
                    // maximum among larger
                    floor = val;
                }
            } else {
                //(val == x)
                ceil = floor = x;
                break;
            }
        }
        System.out.println(ceil + "\n" + floor);
    }

}