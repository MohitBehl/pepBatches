import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        printArr1(arr, 0); //  function is expected to print from 0th pos ->  (n-1) pos
        printArr2(arr, arr.length-1); // function is expected to print from 0th pos ->  (n-1) pos
    }

    public static void printArr1(int arr[],int idx){
        if(idx == arr.length){
            return;
        }

        System.out.println(arr[idx]);
        printArr1(arr, idx+1); //  faith
    }

    public static void printArr2(int arr[],int idx){
        if(idx == -1){
            return;
        }
        printArr2(arr, idx-1); //  faith
        System.out.println(arr[idx]);
    }
}
