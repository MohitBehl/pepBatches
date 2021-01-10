import java.util.Scanner;

public class DivideAndConquer {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        int res[] = mergeSort(arr, 0, arr.length-1);

        System.out.print("Sorted Array -> ");
        print(res);

        quickSort(arr, 0, arr.length - 1);
        print(arr);
        scn.close();
    }

    public static int[] mergeSort(int arr[],int lo,int hi){
        if(lo == hi){
            int base[] = new int[1];
            base[0] = arr[lo];
            return base;
        }
        int mid = (lo + hi)/2;

        int[] lsa = mergeSort(arr, lo, mid);
        int[] rsa = mergeSort(arr, mid+1, hi);

        int[] sarr = mergeTwoSortedArrays(lsa, rsa);
        return sarr;
    }

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

    public static void partition(int[] arr, int pivot) {    
        int i = 0 , j = 0;
        while(i < arr.length){
            if(arr[i] > pivot){
                i++;
            }else if(arr[i] <= pivot){
                swap(arr,i,j);
                i++;
                j++;
            }
        }

    }

    public static void sort01(int[] arr) {
        
        int i = 0, j = 0;
        
        while(i < arr.length){
            if(arr[i] == 1){
                i++;
            }else if(arr[i] == 0){
                swap(arr,i,j);
                i++;
                j++;
            }
        }

    }

    public static void sort012(int[] arr) {
        int i = 0 , j = 0 , k = arr.length-1;
        
        while(i <= k){
            if(arr[i] == 0){
                swap(arr,i,j);
                i++;
                j++;
            }else if(arr[i] == 1){
                i++;
            }else if(arr[i] == 2){
                swap(arr,i,k);
                k--;
            }
        }

    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if(lo > hi ){
            return;
        }
        int pivot = arr[hi];
        int sPivIdx = partition(arr,pivot,lo,hi);
        quickSort(arr,lo,sPivIdx-1);
        quickSort(arr,sPivIdx+1,hi);
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

    public static void print(int []arr){
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
