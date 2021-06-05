public class Intro {
    public static void main(String[] args) {
        int n = 5;
        int fibN = fibonacciR(n);
        System.out.println("Fibonacci recursive : "+ fibonacciR(n));
        System.out.println("Fibonacci memoized : "+ fibonacciM(n,new int[n+1]));
        System.out.println("Fibonacci tabulated : "+fibonacciT(n));
        System.out.println("Fibonacci tabulated optimized : "+fibonacciTOptimized(n));
    }
    public static int fibonacciR(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int fibNm1 = fibonacciR(n-1);
        int fibNm2 = fibonacciR(n-2);

        int fibN = fibNm1 + fibNm2;
        return fibN;
    }

    public static int fibonacciM(int n,int dp[]){
        if(n == 0 || n == 1){
            return dp[n] = n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int fibNm1 = fibonacciM(n-1,dp);
        int fibNm2 = fibonacciM(n-2,dp);

        int fibN = fibNm1 + fibNm2;
        return dp[n] = fibN;
    }

    public static int fibonacciT(int n){
        int dp[] = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            if(i == 0){
                dp[0] = 0;// fib(0) = 0
            }else if(i == 1){
                dp[1] = 1;// fib(1) = 1
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        
        return dp[n];
    }

    public static int fibonacciTOptimized(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int f = 0 , s = 1;
        for(int i = 2 ; i <= n ; i++){
            int t = f + s;
            f = s;
            s = t;
        }
        
        return s;
    }
}
