public class motionInRecursion {
    public static void printDecreasing(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }
    public static void printIncreasing(int n){
        
        if(n == 0){
            return;
        }
        
        printIncreasing(n-1);
        System.out.println(n);
    }
    public static void pdi(int n){
        if(n == 0){
            return;
        }
        System.out.println(n); // my work
        pdi(n-1); // faith
        System.out.println(n); // my work
    }
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int nM1Fact = factorial(n-1); // faith
        int nFact = n * nM1Fact; // my work
        return nFact;
    }
    public static int powerLinear(int x, int n){
        if(n == 0){
            return 1;
        }
        
        int xPowNm1 = powerLinear(x,n-1);
        int xPowN = x * xPowNm1;
        return xPowN;
    }
    public static int powerLog(int x, int n){
        if(n == 0){
            return 1;
        }
        
        int xPowNb2 = powerLog(x,n/2);
        
        int ans = xPowNb2 * xPowNb2;
        
        if(n % 2 == 1){
            ans = x * ans;
        }
        
        return ans;
    }
    public static int fib(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int fibNm1 = fib(n-1); // faith
        int fibNm2 = fib(n-2); // faith
        
        int fibN = fibNm1 + fibNm2; // my work
        
        return fibN;
    }
    public static void pzz(int n){
        if(n == 0){
            return;
        }
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
    }

    public static void toh(int n, int src, int dest, int helper){
        if(n == 0){
            return;
        }
        toh(n-1,src,helper,dest);
        System.out.println(n+"["+src+" -> "+dest+"]");
        toh(n-1,helper,dest,src);
    }
}
