import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt(); // to find : first occurance of ele in arr.

        System.out.println(firstIndex(arr, 0, ele));
    }

    public static int firstIndex(int[] arr, int idx, int ele) {
        if (idx == arr.length) {
            // element not found
            return -1;
        }
        if (arr[idx] == ele) {
            return idx;
        }

        int rres = firstIndex(arr, idx + 1, ele);
        return rres;
    }

}
