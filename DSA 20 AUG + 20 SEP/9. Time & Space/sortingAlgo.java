import java.util.Scanner;

public class sortingAlgo {
        // used for swapping ith and jth elements of array
        public static void swap(int[] arr, int i, int j) {
            System.out.println("Swapping " + arr[i] + " and " + arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    
        // return true if ith element is smaller than jth element
        public static boolean isSmaller(int[] arr, int i, int j) {
            System.out.println("Comparing " + arr[i] + " and " + arr[j]);
            if (arr[i] < arr[j]) {
                return true;
            } else {
                return false;
            }
        }
    
        public static void print(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }

        // return true if jth element is greater than ith element
        public static boolean isGreater(int[] arr, int j, int i) {
            System.out.println("Comparing " + arr[i] + " and " + arr[j]);
            if (arr[i] < arr[j]) {
                return true;
            } else {
                return false;
            }
        }
        public static void bubbleSort(int arr[]){
            int n = arr.length;
            for(int itr = 1 ; itr <= n-1 ; itr++){
                for(int j = 0 ; j <= n - itr - 1; j++){
                    //arr[j] > arr[j+1] --> swapping
                    if(isSmaller(arr,j+1,j)){
                        swap(arr,j+1,j);
                    }
                }
            }
        }

        public static void selectionSort(int arr[]){
            int n = arr.length;
            for(int itr = 1 ; itr <= n-1 ; itr++){
                int minIdx = itr-1;
                for(int j = itr ; j < n ; j++){
                    if(isSmaller(arr,j,minIdx)){
                        minIdx = j;
                    }
                }
                swap(arr,itr-1,minIdx);
            }
        }
        
        public static void insertionSort(int[] arr) {
            int n = arr.length;
            for(int itr = 1 ; itr <= n-1 ; itr++){
                for(int j = itr ; j>0;j--){
                    if(isGreater(arr,j-1,j)){
                        swap(arr,j-1,j);
                    }else{
                        break;
                    }
                }
            }
        }
        
        public static int[] mergeSort(int[] arr, int lo, int hi) {
            if (lo == hi) {
                int base[] = new int[1];
                base[0] = arr[lo];
                return base;
            }
            int mid = (lo + hi) / 2;
            int left[] = mergeSort(arr, lo, mid);
            int right[] = mergeSort(arr, mid + 1, hi);
            int res[] = mergeTwoSortedArrays(left, right);
            return res;
        }
    
        //used for merging two sorted arrays
        public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
            System.out.println("Merging these two arrays ");
            System.out.print("left array -> ");
            print(a);
            System.out.print("right array -> ");
            print(b);
            int i = 0, j = 0, k = 0;
            int[] ans = new int[a.length + b.length];
            while (i < a.length && j < b.length) {
                if (a[i] <= b[j]) {
                    ans[k] = a[i];
                    i++;
                    k++;
                } else {
                    ans[k] = b[j];
                    j++;
                    k++;
                }
            }
    
            while (i < a.length) {
                ans[k] = a[i];
                k++;
                i++;
            }
    
            while (j < b.length) {
                ans[k] = b[j];
                k++;
                j++;
            }
    
            return ans;
        }

        public static void quickSort(int[] arr, int lo, int hi) {
            if (lo > hi) {
                return;
            }
            int pivot = arr[hi];
            int pivotIdx = partition(arr, pivot, lo, hi);
            quickSort(arr, lo, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, hi);
        }
    
        public static int partition(int[] arr, int pivot, int lo, int hi) {
            System.out.println("pivot -> " + pivot);
            int i = lo, j = lo;
            while (i <= hi) {
                if (arr[i] <= pivot) {
                    swap(arr, i, j);
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            System.out.println("pivot index -> " + (j - 1));
            return (j - 1);
        }
        
        public static int quickSelect(int[] arr, int lo, int hi, int k) {
            int pivot = arr[hi];
            int pivotIdx = partition(arr, pivot, lo, hi);
    
            if (pivotIdx == k) {
                return pivot;
            } else if (k < pivotIdx) {
                return quickSelect(arr, lo, pivotIdx - 1, k);
            } else {
                // if(k > pivotIdx0)
                return quickSelect(arr, pivotIdx + 1, hi, k);
            }
        }

        public static void countSort(int[] arr, int min, int max) {
            int noe = max - min + 1;
    
            int farr[] = new int[noe];
            for (int i = 0; i < arr.length; i++) {
                farr[arr[i] - min]++;
            }
    
            for (int i = 1; i < farr.length; i++) {
                farr[i] = farr[i] + farr[i - 1];
            }
    
            int res[] = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                int inpVal = arr[i];
                int idx = inpVal - min;
                int pos = farr[idx];
                res[pos - 1] = inpVal;
                farr[idx]--;
            }
    
            for (int i = 0; i < arr.length; i++) {
                arr[i] = res[i];
            }
        }

        public static void radixSort(int[] arr) {
            int max = Integer.MIN_VALUE;
    
            for (int val: arr) {
                if (val > max) {
                    max = val;
                }
            }
    
            int count = 0;
            while (max != 0) {
                count++;
                max /= 10;
            }
    
            for (int itr = 0; itr < count; itr++) {
                countSort(arr, (int) Math.pow(10, itr));
            }
        }
    
        public static void countSort(int[] arr, int exp) {
            int farr[] = new int[10];
    
            for (int num: arr) {
                int digit = (num / exp) % 10;
                farr[digit]++;
            }
    
            for (int i = 1; i < farr.length; i++) {
                farr[i] = farr[i] + farr[i - 1];
            }
    
            int res[] = new int[arr.length];
    
            for (int i = arr.length - 1; i >= 0; i--) {
                int num = arr[i];
                int digit = (num / exp) % 10;
                int pos = farr[digit];
                res[pos - 1] = num;
                farr[digit]--;
            }
    
            for (int i = 0; i < arr.length; i++) {
                arr[i] = res[i];
            }
    
            System.out.print("After sorting on " + exp + " place -> ");
            print(arr);
        }

        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int arr[] = new int[n];
            for(int i = 0 ;i < arr.length ; i++){
                arr[i] = scn.nextInt();
            }

            bubbleSort(arr);
            print(arr);
        }
}
