import java.util.*;

public class Main {

    public static void main(String[] args) {

        int arr[] = {
            8,
            16,
            24,
            32,
            49,
            67,
            70,
            78,
            90
        };

        int ele = 25;

        System.out.println(binarySearch(arr, ele));
    }

    public static int binarySearch(int arr[], int ele) {
        int lo = 0;
        int hi = arr.length - 1;


        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == ele) {
                // element found
                return mid;
            } else if (ele < arr[mid]) {
                // move to smaller region
                hi = mid - 1;
            } else if (ele > arr[mid]) {
                // move to larger region
                lo = mid + 1;
            }
        }
        // implication :  element was never found
        return -1;
    }
}