public class L001 {
    public static void main(String[] args) {
        System.out.println(sum(4));
    }

    public static int sum(int num){
        if(num == 0){
            return 0;
        }
        num =num -1;
        int rres = sum(num);

        return rres + num;
    }

    public static void pdi(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

    public static void printIncreasing(int n){
        if(n == 0){
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static void printDecreasing(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printOddSmart(int n){
        if(n <= 0){
            return;
        }
        if(n % 2 == 0){
            printOddSmart(n-1);
        }else{
            printOddSmart(n-2);
            System.out.println(n);
        }
    }

    public static int powerActualSmart(int x, int n){
        if(n == 0){
            return 1;
        }
        int xPowNBy2 = powerActualSmart(x,n/2);
        int xPowN = xPowNBy2 * xPowNBy2;
        if(n%2 == 1){
            xPowN *= x;
        }
        return xPowN;
    }
    
    public static int powerFakeSmart(int x, int n){
        if(n == 0){
            return 1;
        }
        int xPowN = powerFakeSmart(x,n/2) * powerFakeSmart(x,n/2);
        if(n%2 == 1){
            xPowN *= x;
        }
        return xPowN;
    }

    public static int powerLinear(int x, int n){
        if(n == 0){
            return 1;
        }
        int xPowNm1 = powerLinear(x,n-1);
        int xPowN = x * xPowNm1;
        return xPowN;
    }
}
