public class partitionAnArray {
    public static void partitionLargerSmaller(int[] arr, int pivot) {
        int i = 0, j = 0;
        // 0 - (j-1) : smaller
        // j - (i-1) : larger
        // i - (len-1) : unknowns
        while(i < arr.length){
            if(arr[i] <= pivot){
                // smaller
                swap(arr,i,j);
                i++;
                j++;
            }else{
                // larger
                i++;
            }
        }
    }

    public static void sort01(int[] arr) {

        int i = 0 , j = 0;
        
        // 0 - (j-1) : 0's
        // j - (i-1) : 1's
        // i - (len-1) : unkowns(0/1)
        
        while(i < arr.length){
            if(arr[i] == 0){
                // 0's
                swap(arr,i,j);
                i++;
                j++;
            }else{
                // 1's
                i++;
            }
        }
    }

    public static void sort012(int[] arr) {
        int i = 0 , j = 0 , k = arr.length-1;
        
        // 0 - (j-1) : 0's
        // j - (i-1) : 1's
        // i - k : unknowns(0/1/2)
        //(k+1) - (len-1) : 2's
        
        while(i <= k){
            if(arr[i] == 0){
                swap(arr,i,j);
                i++;
                j++;
            }else if(arr[i] == 1){
                i++;
            }else{
                // arr[i] == 2
                swap(arr,i,k);
                k--;
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

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        partitionLargerSmaller(arr, pivot);
        print(arr);
    }
}
