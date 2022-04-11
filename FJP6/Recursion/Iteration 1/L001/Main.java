import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // printIncreasing(n);
        // printDecreasing(n);
        // int ans = factorial(n);
        int ans = powerLinear(2, 5);

        System.out.println(ans);
    }

    public static void printIncreasing(int n){
        if(n == 0){ // base case
            return;
        }
        printIncreasing(n-1); // faith
        System.out.println(n);
    }

    public static void printDecreasing(int n){
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }

        int factNm1 = factorial(n-1);
        int factN = n * factNm1;

        return factN;
    }

    public static int powerLinear(int x,int n){ // x^n
        if(n == 0){
            return 1;
        }
        int xPowNm1 = powerLinear(x, n-1);
        int xPowN = x * xPowNm1;
        return xPowN;
    }
}
