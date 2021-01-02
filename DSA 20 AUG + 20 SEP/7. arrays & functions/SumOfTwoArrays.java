import java.util.Scanner;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int arr1[] = new int[n1];
        for(int i = 0 ; i < n1 ; i++){
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int arr2[] = new int[n2];
        for(int i = 0 ; i < n2 ; i++){
            arr2[i] = scn.nextInt();
        }

        int []res = sum(arr1,arr2);
        for(int val:res){
            System.out.println(val);
        }
    }

    public static int[] sum(int arr1[],int arr2[]){
        int res[] = new int[Math.max(arr1.length,arr2.length)];

        int i = arr1.length-1; // arr1 pointer
        int j = arr2.length-1; // arr2 pointer
        int k = res.length-1; // res pointer
        int carry = 0;
        while(i >= 0 || j >= 0){
            // get values
            int v1 = i >= 0 ? arr1[i] : 0; // digit from arr1
            int v2 = j >= 0 ? arr2[j] : 0; // digit from arr2

            // Sum
            int sum = v1 + v2 + carry;

            int digit = sum % 10; // actual val to be stored
            carry = sum / 10; // update carry for further digits

            res[k] = digit;

            // update pointers
            i--;
            j--;
            k--;
        }

        if(carry == 0){
            return res;
        }else{
            // resize
            int resizedRes[] = new int[res.length+1];
            resizedRes[0] = carry;

            // copy
            for(int idx = 1; idx < resizedRes.length ; idx++){
                resizedRes[idx] = res[idx-1];
            }

            return resizedRes;
        }
    }
}
