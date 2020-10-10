import java.util.*;

public class Main {

    public static void main(String[] args) {

        // declaration
        int arr[] = new int[5];
        
        // index --> [0-4]
        
        // values --> assign
        arr[0] = 10;
        arr[1] = -2;
        arr[2] = 69;
        arr[4] = 90;
        
        for(int idx = 0 ; idx < 5 ; idx++){
            System.out.println(idx+"-->"+arr[idx]);
        }

        // declaration + assign
        int arr1[] = {10,-2,69,0,90,132};
        
        for(int idx = 0 ; idx < 6 ; idx++){
            System.out.println(idx+"-->"+arr1[idx]);
        }
        
        arr1[7] = 10; // error : index out of bounds because 7th index is not part of valid-index-range
    
        // input
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int brr[] = new int[n];
        for(int idx = 0 ; idx < n ;idx++){
            brr[idx] = scn.nextInt();
        }
        
        System.out.println("display");
        for(int idx = 0 ; idx < n ;idx++){
            System.out.print(brr[idx] +" --> ");
        }
        System.out.println(".");
        
        // special functionality
        System.out.println(brr.length);
    }
}