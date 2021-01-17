import java.util.Scanner;
import java.util.Arrays;
public class TargetSumPair {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr,target);
    }

    public static void targetSumPair(int arr[],int target){
        Arrays.sort(arr);// sort the array

        // 2ptr approach
        int lo = 0 , hi = arr.length-1;

        while(lo < hi){
            int v1 = arr[lo];
            int v2 = arr[hi];

            if(v1 + v2 < target){
                lo++;
            }else if(v1 + v2 > target){
                hi--;
            }else{
                System.out.println(v1+", "+v2);
                lo++;
                hi--;
            }
        }
    }
}
