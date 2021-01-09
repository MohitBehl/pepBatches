public class ComparisonBasedSorting {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int itr = 1; itr < n; itr++) {
            for (int j = 0; j < n - itr; j++) {
                if (isSmaller(arr, j + 1, j) == true) {
                    swap(arr, j + 1, j);
                }
            }
        }

    }

    public static void selectionSort(int[] arr) {
    
        int n = arr.length;
        
        for(int itr = 1 ; itr < n ; itr++){
            int mIdx = itr-1;
            for(int j = itr ; j < n ; j++){
                if(isSmaller(arr,j,mIdx) == true){
                    mIdx = j;
                }
            }
            swap(arr,itr-1,mIdx);
        }

    }

    public static void insertionSort(int[] arr) {
    
        int n = arr.length;
        
        for(int itr = 1; itr < n ; itr++){
            for(int j = itr - 1; j>=0 ; j--){
                if(isGreater(arr,j,j+1) == true){
                    swap(arr,j,j+1);
                }else{
                    break;
                }
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

    // return true if jth element is greater than ith element
    public static boolean isGreater(int[] arr, int j, int i) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
        }
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

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        bubbleSort(arr);
        print(arr);
    }
}
