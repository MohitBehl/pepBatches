public class Main{
    public static void main(String[] args) {
        int arr[]= {10,35,45,56,63,69,74,88,91};
        int ele = 88;

        int li = 0 ;
        int ri = arr.length-1;

        while(li <= ri){
            int mid = (li + ri)/2;

            if(arr[mid] == ele){
                // element found at index mid
                System.out.println("element found at "+mid);
                return;
            }else if(ele > arr[mid]){
                // larger area
                li = mid + 1;
            }else{
                // smaller area
                ri = mid - 1;
            }
        }
        System.out.println("not found");
    }
}