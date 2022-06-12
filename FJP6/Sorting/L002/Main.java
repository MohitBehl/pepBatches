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

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}