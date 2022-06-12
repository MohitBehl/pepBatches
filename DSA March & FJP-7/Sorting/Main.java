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
        
    }

}