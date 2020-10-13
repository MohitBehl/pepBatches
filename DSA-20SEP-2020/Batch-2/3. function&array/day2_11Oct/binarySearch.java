import java.util.*;

public class Main {

    public static void main(String[] args) {

        int arr[] = {
            1,
            7,
            9,
            16,
            18,
            19,
            25,
            45,
            65,
            78,
            84
        };
        int ele = 79;

        System.out.println(binarySearch(arr, ele));
    }
    public static int binarySearch(int arr[], int ele) {
        int li = 0;
        int ri = arr.length - 1;

        while (li <= ri) {

            int mid = (li + ri) / 2;

            if (arr[mid] == ele) {
                // element found
                return mid;
            } else if (arr[mid] > ele) {
                // smaller area
                ri = mid - 1;
            } else if (arr[mid] < ele) {
                // larger area
                li = mid + 1;
            }
        }

        //  implication that element has not been found
        return -1;
    }
}