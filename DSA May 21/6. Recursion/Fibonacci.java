public class Fibonacci{
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int fibNm1 = fib(n-1);
        int fibNm2 = fib(n-2);

        int fibN = fibNm1 + fibNm2;

        return fibN;
    }
}