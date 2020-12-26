public class recursionInArrays {
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
        displayArrReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == x) {
            // first occurance
            return idx;
        }

        return firstIndex(arr, idx + 1, x);
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1; // we assume element doesn't exists
        }
        int li = lastIndex(arr, idx + 1, x);

        if (li == -1) {
            if (arr[idx] == x) {
                // first element from the last --> last occurance
                return idx;
            }
        }
        return li;
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length) {
            int res[] = new int[fsf];
            return res;
        }
        if (arr[idx] == x) {
            int res[] = allIndices(arr, x, idx + 1, fsf + 1);
            res[fsf] = idx;
            return res;
        } else {
            int res[] = allIndices(arr, x, idx + 1, fsf);
            return res;
        }
    }

    public static int maxOfArray(int[] arr, int idx) {
        if (arr.length == idx) {
            return Integer.MIN_VALUE;
        }

        int lMax = maxOfArray(arr, idx + 1);

        if (lMax < arr[idx]) {
            return arr[idx];
        } else {
            return lMax;
        }
    }
}
