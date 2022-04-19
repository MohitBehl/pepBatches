import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // //  input
        // int n = scn.nextInt();
        // int arr[] = new int[n];
        // for(int i = 0 ; i < n ; i++){
        //     arr[i] = scn.nextInt();
        // }
        // int k = scn.nextInt();

        // // rotate
        // rotate(arr, k);
        // // display
        // display(arr);


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

        int res[] = sum(arr1, arr2);
        display(res);
    }

    public static void rotate(int arr[],int k){
        k = k % arr.length;

        if(k < 0)
            k = k + arr.length;
        
        // reverse part 2
        reverse(arr, arr.length-k, arr.length-1);
        // reverse part 1
        reverse(arr, 0, arr.length-k-1);
        // reverse arr
        reverse(arr, 0, arr.length-1);
    }
    public static void reverse(int arr[],int left,int right){
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    public static void display(int arr[]){
        for(int vl : arr){
            System.out.print(vl+" ");
        }
    }


    public static int[] sum(int arr1[],int arr2[]){
        int size = Math.max(arr1.length,arr2.length);

        int res[] = new int[size];

        int p1 = arr1.length-1, p2 = arr2.length-1 , p3 = size-1;
        int carry = 0;

        while(p3 >= 0){
            int v1 = (p1 >= 0) ? arr1[p1] : 0;
            int v2 = (p2 >= 0) ? arr2[p2] : 0;

            int sum = v1 + v2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            res[p3] = digit;

            p1--; p2--; p3--;
        }

        if(carry == 0){
            return res;
        }else{
            int newRes[] = new int[size+1];
            newRes[0] = carry;
            for(int i  = 1; i < newRes.length ; i++){
                newRes[i] = res[i-1];
            }
            return newRes;
        }
    }
}
