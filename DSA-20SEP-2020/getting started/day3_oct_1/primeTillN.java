import java.util.*;
public class primeTillN{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int sp = scn.nextInt();
        int ep = scn.nextInt();

        for(int num = sp ; num <= ep ; num++){
            // code for checking whether number is a prime or not
            boolean isPrime = true;
            for(int fac = 2 ; fac*fac <= num ; fac++){
                if(num%fac == 0){
                    // number is completly divisible by fac thus number is not a prime.
                    isPrime = false;
                    break;
                }
            }

            if(isPrime == true){
                //  number is a prime 
                System.out.println(num);
            }
        }
    }
}