import java.util.*;

public class primeFactorization{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        for(int fac = 2 ; fac*fac <= num ; fac++){
            while(num%fac == 0){
                System.out.print(fac+" ");
                num = num/fac;
            }
        }

        if(num != 1){
            // number is a prime itself
            System.out.println(num);
        }
    }
}