import java.util.*;

public class Main {
    public static void arrayIntro(){
        // int a[]  = {115,0,120,13,456,14,12,13,456,4687,431,54,31,5342,1,5421,54};
        int arr[] = new int[5];
        // index : 0,1,2,3,4
        arr[0] = 115;
        arr[2] = 25;
        arr[3] = 10;
        arr[4] = -20;

        for(int idx = 0 ; idx < arr.length ; idx++){
            int vl = arr[idx];
            System.out.println(idx+" "+vl);
        }        
        System.out.println("-----------------------------");
        int i = 0;
        while(i < arr.length){
            int vl = arr[i];
            System.out.println(i+" "+vl);
            i++;
        }
        System.out.println("-----------------------------");

        System.out.println(Arrays.toString(arr));

        System.out.println("-----------------------------");

        for(int v : arr){
            System.out.println(v);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int d = scn.nextInt();
        // int f = getDigitFrequency(n, d);
        // System.out.println(f);
        // arrayIntro();

        // Span Of Array
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int idx = 0 ; idx < n ; idx++){
            arr[idx] = scn.nextInt();
        }
        int ans = spanOfArray(arr);
        System.out.println(ans);
    }   

    public static int spanOfArray(int arr[]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int vl : arr){
            if(vl > max){ //  better maximum
                max = vl;
            }
            if(vl < min){ //  better minimum
                min = vl;
            }
        }
        return max-min;
    }
    public static int getDigitFrequency(int n, int d) {
        int count = 0;

        while(n != 0){
            int digit = n % 10;
            n = n / 10;
            if(digit == d){
                count++;
            }
        }

        return count;
    }

    public static void reverse(int[] a){
        // write your code here
    }
}