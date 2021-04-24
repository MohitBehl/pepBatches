import java.util.Scanner;
public class L001 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);

        // int n = scn.nextInt();
        //   int sourceBase = scn.nextInt();
        //  int  destBase= scn.nextInt();
         
        //  int cVal = anyBaseToAnyBase(n,sourceBase,destBase);
         
        //  System.out.println(cVal);
    }

    public static int getDigitFrequency(int n, int d) {
        int count = 0;
        
        while(n > 0){
            int rem = n % 10;
            if(rem == d){
                count += 1;
            }
            
            n = n / 10;
        }
        
        return count;
    }

    public static int getValueIndecimal(int n, int b){
        int pos = 0;
        int rv = 0;
        
        while(n > 0){
            int rem = n % 10;
            
            rv = rv + (rem*(int)Math.pow(b,pos));
            
            pos += 1;
            n = n/10;
        }
        
        return rv;
     }

     public static int getValueInBase(int n, int b){
        int rv = 0;
        int pow = 1;
        
        while(n > 0){
            int rem = n%b;
            rv = rv + (rem*pow);
            pow = pow*10;
            n = n / b;
        }
        
        return rv;
    }

    public static int anyBaseToAnyBase(int num,int b1,int b2){
        int dval = getValueIndecimal(num,b1); // anyBaseToDecimal
        int cval = getValueInBase(dval,b2); // decimalToAnyBase
        
        return cval;
    }

}
