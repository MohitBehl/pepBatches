public class Main {
    public static void printIncreasing(int n){
        if(n == 0) return;
        printIncreasing(n-1); // faith
        System.out.println(n);
    }
    public static void printDecreasing(int n){
        if(n == 0) return;
        System.out.println(n);
        printDecreasing(n-1); // faith
    }
    public static void printDecreasingIncreasing(int n){
        // Homework  
    }
    public static int factorial(int n){
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

    public static int powerLinear(int x,int n){ // x ^ n
        if(n == 0) return 1;
        return x * powerLinear(x, n-1);
    }

    public static int powerLog(int x,int n){
        if(n == 0) return 1;
        int xPowNBy2 = powerLog(x, n/2);
        int ans = xPowNBy2 * xPowNBy2;
        if(n % 2 == 1) ans = ans * x;
        return ans;
    }
    public static void main(String[] args) {
        printIncreasing(5); // 1 2 3 4 5
        printDecreasing(5); // 5 4 3 2 1
        printDecreasingIncreasing(3); // 3 2 1 1 2 3 

        System.out.println(factorial(5)); // 5! = 5.4.3.2.1 = 120 , 0! = 1
    }
}
