import java.util.Scanner;

public class Main {
    public static boolean binarySearch(int arr[],int ele){ // increasing Order
        int left = 0 , right = arr.length-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(ele == arr[mid]){
                return true;
            }else if(ele > arr[mid]){ // move right
                left = mid + 1;
            }else if(ele < arr[mid]){
                right = mid - 1;
            }
        }
        return false;
    }  
    
    // arr : 1 2 2 2 3 4 , k = 2 
    public static int firstIdx(int arr[] ,int k){
        int left = 0 , right = arr.length-1;
        int idx = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == k){
                idx = mid;
                right = mid-1;
            }else if(k > arr[mid]){
                left = mid+1;
            }else if(k < arr[mid]){
                right = mid-1;
            }
        }
        return idx;
    }
    public static int lastIdx(int arr[] ,int k){
        int left = 0 , right = arr.length-1;
        int idx = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == k){
                idx = mid;
                left = mid + 1;
            }else if(k > arr[mid]){
                left = mid+1;
            }else if(k < arr[mid]){
                right = mid-1;
            }
        }
        return idx;
    }


    public static void printAllSubArrays(int arr[]){
        for(int sp = 0 ; sp < arr.length ; sp++){
            for(int ep = sp ; ep < arr.length ; ep++){

                for(int i = sp ; i <= ep ; i++){ //  print
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        // int ele = scn.nextInt();

        // boolean res = binarySearch(arr, ele);

        // System.out.println(firstIdx(arr, ele));
        // System.out.println(lastIdx(arr, ele));
        printAllSubArrays(arr);
    }
}
