import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = scn.nextInt();

        displayArr(arr, 0);
        displayArrReverse1(arr, 0);
        displayArrReverse2(arr, arr.length-1);
        displayArrReverse3(arr, arr.length-1);
    }
    public static void displayArr(int arr[],int idx){
        if(idx == arr.length) return;
        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
    }

    // displayArrReverse1(arr,0)
    public static void displayArrReverse1(int arr[],int idx){
        if(idx == arr.length) return;
        displayArrReverse1(arr, idx+1);
        System.out.println(arr[idx]);
    }

    // displayArrReverse2(arr,arr.length-1)
    public static void displayArrReverse2(int arr[],int idx){
        if(idx == -1) return;
        System.out.println(arr[idx]);
        displayArrReverse2(arr, idx-1);
    }

    // displayArrReverse3(arr,arr.length-1)
    public static void displayArrReverse3(int arr[],int idx){
        if(idx == 0){System.out.println(arr[idx]); return;}
        System.out.println(arr[idx]);
        displayArrReverse3(arr, idx-1);
    }

    public static int max(int arr[],int idx){
        if(idx == arr.length) return Integer.MIN_VALUE;

        int omax = max(arr,idx+1);

        if(omax > arr[idx]) return omax;
        return arr[idx];
    }

    // public static int firstIndex(int arr[],int idx){
    //     // HW
    // }
    
    // public static int lastIndex(int arr[],int idx){
    //     // HW
    // }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if(idx == arr.length){
            return new int[fsf];
        }
        if(arr[idx] == x){
            int rres[] = allIndices(arr, x, idx+1, fsf+1);
            rres[fsf] = idx;
            return rres;
        }else{
            return allIndices(arr, x, idx+1, fsf);
        }
    }
}
