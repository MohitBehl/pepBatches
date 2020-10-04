import java.util.*;

public class isNumberPrime{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t != 0){
            int num = scn.nextInt();

            // code for checking wether number is a prime or not.
            boolean isPrime = true;
            for(int fac = 2 ; fac * fac <= num ; fac++){
                if(num%fac == 0){
                    // atleast 1 extra factor exists, therefore number is not a prime 
                    isPrime = false;
                    break;
                }
            }

            if(isPrime == true){
                // no extra factor exists
                System.out.println("prime");
            }else{
                System.out.println("not prime");
            }

            t--;
        }
    }
}