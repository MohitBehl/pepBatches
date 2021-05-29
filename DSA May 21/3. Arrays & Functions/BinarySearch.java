public class BinarySearch{
    public static void main(String[] args) {
        int arr[] = {10,20,40,50,69,70,74,87,95,101,240,300,360,470};

        int k = 101;

        int lo = 0 , hi = arr.length-1;
        int idx = -1;
        int count = 0;
        while(lo <= hi){
            count++;
            int mid = (lo + hi)/2;

            if(k > arr[mid]){
                lo = mid+1;
            }else if(k < arr[mid]){
                hi = mid-1;
            }else{
                idx = mid; 
                break;
            }
        }
        System.out.println(idx);
        System.out.println(count);
    }
}