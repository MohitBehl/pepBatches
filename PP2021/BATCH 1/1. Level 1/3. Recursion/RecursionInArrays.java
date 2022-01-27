import java.util.Scanner;

/**
 * RecursionInArrays
 */
public class RecursionInArrays {
    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }
    public static void displayArrReverse(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        displayArr(arr, idx + 1);
        System.out.println(arr[idx]);
    }
    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == x) {
            return idx;
        }

        int ans = firstIndex(arr, idx + 1, x);
        return ans;
    }
    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int rres = lastIndex(arr, idx + 1, x);

        if (rres == -1) {
            // last occurrance has not been figured out 
            if (arr[idx] == x) {
                rres = idx;
            }
        }
        return rres;
    }
    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length) {
            int base[] = new int[fsf];
            return base;
        }
        int res[];
        if (arr[idx] == x) {
            res = allIndices(arr, x, idx + 1, fsf + 1);
            res[fsf] = idx;
        } else {
            res = allIndices(arr, x, idx + 1, fsf);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // displayArr(arr, 0);
        // displayArrReverse(arr,0);

        int x = scn.nextInt();

        // System.out.println(firstIndex(arr, 0, x));
        // System.out.println(lastIndex(arr, 0, x));
        int res[] = allIndices(arr, x, 0, 0);

        if (res.length != 0) {
            for (int val: res) {
                System.out.println(val);
            }
        }
        System.out.println();
    }
}