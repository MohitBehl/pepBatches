import java.util.*;

public class Main {

    public static void main(String[] args) {

        // int arr[] = new int[5];
        // // index : 0 , 1, 2, 3, 4, 5

        // arr[0] = 100;
        // arr[1] = -23;
        // arr[4] = 65;
        // arr[3] = 456;

        // // System.out.println(arr[0]);
        // // System.out.println(arr[1]);
        // // System.out.println(arr[2]);
        // // System.out.println(arr[3]);
        // // System.out.println(arr[4]);
        
        // for(int idx = 0 ; idx < arr.length; idx++){
        //     System.out.println(idx+" -> "+ arr[idx]);
        // }
        
        // System.out.println("size of an array : "+arr.length);
        
        // int arr1[] = {10,20,30,40,50,60};
        
        // for(int idx = 0 ; idx < arr1.length; idx++){
        //     System.out.println(idx+" -> "+ arr1[idx]);
        // }
        
        // System.out.println("size of an array1 : "+arr1.length);


        // Scanner scn = new Scanner(System.in);
        // int size = scn.nextInt();
        // int arr[] = new int[size];

        // for(int idx = 0 ; idx < arr.length ; idx++){
        //     arr[idx] = scn.nextInt();
        // }

        // for(int idx = 0 ; idx < arr.length ; idx++){
        //     System.out.println(idx+" --> "+arr[idx]);
        // }

        // System.out.println("size : "+arr.length);

        Scanner scn = new Scanner(System.in);
    
        int size = scn.nextInt();
        
        int arr[];
        arr = new int[size];
        
        for(int idx = 0 ; idx < arr.length ; idx++){
            arr[idx] = scn.nextInt();
        }
        
        int sum = 0;
        for(int idx = 0 ; idx < arr.length ; idx++){
            sum = sum + arr[idx];
        }
        
        System.out.println(sum);
    }
}