import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        System.out.println(firstOccurance(arr, k));
        System.out.println(lastOccurance(arr, k));
    }

    public static int firstOccurance(int arr[], int k) {
        int lo = 0, hi = arr.length - 1;
        int fi = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == k) {
                // possible first occurance
                fi = mid;
                // find better first occurance --> move to smaller region
                hi = mid - 1;

            } else if (k < arr[mid]) {
                // smaller area
                hi = mid - 1;
            } else if (k > arr[mid]) {
                lo = mid + 1;
            }
        }
        return fi;
    }
    public static int lastOccurance(int arr[], int k) {
        int lo = 0, hi = arr.length - 1;
        int li = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == k) {
                // possible last occurance
                li = mid;
                // find better last occurance --> move to larger region
                lo = mid + 1;

            } else if (k < arr[mid]) {
                // smaller area
                hi = mid - 1;
            } else if (k > arr[mid]) {
                lo = mid + 1;
            }
        }
        return li;
    }
}