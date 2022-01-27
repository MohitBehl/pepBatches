import java.util.Scanner;

public class L002 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(fib(n)); 
        // pzz(n);
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        
        displayArr(arr,0);     
        displayArrReverse(arr,0);
        System.out.println(maxOfArray(arr,0));

        toh(10,11,12,3);
    }

    public static int fib(int n){
        if(n == 1){
            return 0; 
        }
        if(n == 2){
            return 1;
        }
        int fibNm1 = fib(n-1);
        int fibNm2 = fib(n-2);
        int fibN = fibNm1 + fibNm2;
        
        return fibN;
    }

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr,idx+1);
    }

    public static void displayArrReverse(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        displayArrReverse(arr,idx+1);
        System.out.println(arr[idx]);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length){
            return Integer.MIN_VALUE;
        }
        int res = maxOfArray(arr,idx+1);
        if(res > arr[idx]){
            return res;
        }else{
            return arr[idx];
        }
    }

    public static void pzz(int n){
        if(n == 1){
            System.out.print("1 1 1 ");
            return;
        }
        
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
    }

    public static void toh(int src,int dest,int helper,int n){
        if(n == 0){
            return;
        }
        toh(src,helper,dest,n-1);
        System.out.println(n+"["+src+" -> "+dest+"]");
        toh(helper,dest,src,n-1);
    }
}
