public class Main{
    public static void main(String[] args) {
        int inp[] = {10,30,45,62,78,84,89,100,150,180,192,300};
        int x = 150;

        int res = binarySearch(inp, x);
        System.out.println(res);
    }
    public static int binarySearch(int inp[],int x){
        int lo = 0;
        int hi = inp.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(inp[mid] == x){
                return mid; // element found
            }else if(x < inp[mid]){
                hi = mid-1;// search area reduces to left
            }else{
                lo = mid+1;// search area reduces to right
            }
        }

        return -1; // element not found
    }
}