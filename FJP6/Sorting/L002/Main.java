public class Main{
    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        int res[] = new int[a.length + b.length];
        int p1 = 0 , p2 = 0 , idx = 0;

        while(idx < res.length){
        int v1 = (p1 < a.length) ? a[p1] : Integer.MAX_VALUE;
        int v2 = (p2 < b.length) ? b[p2] : Integer.MAX_VALUE;

        if(v1 < v2){
            res[idx] = v1;
            idx++;
            p1++;
        }else{
            res[idx] = v2;
            idx++;
            p2++;
        }
        }
        
        return res;
    }

    public static int[]mergeSort(int arr[],int lo,int hi){
        if(lo == hi){
            int base[] = new int[1];
            base[0] = arr[lo];
            return base;
        }
       int mid = (lo+hi)/2;

       int left[] = mergeSort(arr,lo,mid);
       int right[] = mergeSort(arr,mid+1,hi);

       return mergeTwoSortedArrays(left,right);
    }

    public int[] sortArray(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }


    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void partition(int[] arr, int pivot){
        int i = 0, j = 0;

        while(j < arr.length){
            if(arr[j] <= pivot){
                swap(arr,j,i);
                i++;
                j++;
            }else{
                j++;
            }
        }
        
    }

    public static int getPivotIndexAfterPartition(int[] arr, int pivot , int lo,int hi){
        int i = lo, j = lo;

        while(j <= hi){
            if(arr[j] <= pivot){
                swap(arr,j,i);
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return i-1;
    }

   public static void quickSort(int arr[],int lo,int hi){
        // if(lo > hi) return; // invalid range
        // if(hi == lo) return; // because 1 ele array is always sorted

        int pivot = arr[hi];
        int pidx = getPivotIndexAfterPartition(arr,pivot,lo,hi);

        if(lo < pidx-1)
            quickSort(arr,lo,pidx-1);
        if(pidx+1 < hi)
            quickSort(arr,pidx+1,hi);
    }
}