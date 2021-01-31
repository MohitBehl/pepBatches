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
        int ele = scn.nextInt();
        int idx = find(arr, ele);
        System.out.println(arr[idx]);
    }

    public static int find(int arr[], int ele) {
        // code
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] == ele) {
                return idx;
            }
        }

        // implication
        return -1;
    }

}