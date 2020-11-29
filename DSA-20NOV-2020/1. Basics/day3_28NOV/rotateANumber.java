import java.util.Scanner;

public class rotateANumber {

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int number = scn.nextInt();
        int k = scn.nextInt(); // rotation number  ,+ve (anti-clockwise) ,-ve (clockwise)

        // number of digits 
        int tmp = number;
        int nDigits = 0;

        while(tmp != 0){
            tmp = tmp / 10; // reduce by 1 digit
            nDigits++;
        }
        // nDigits will represent number of digits

        // true rotation number
        k %= nDigits; // shorthand , k = k % count;

        // conversion from -ve --> +ve
        if(k < 0){
            k = k + nDigits;
        }


        // main logic (divide &  merge)

        int powMerge = 1 , powDivide = 1;

        for(int i = 1 ; i <= nDigits ; i++){
            if(i <= nDigits-k){
                // p1
                powMerge = powMerge * 10;
            }else{
                // p2
                powDivide = powDivide * 10;
            }
        }

        // 1. divide
        int p1 = number / powDivide;
        int p2 = number % powDivide;

        // merge
        int ans = (p2 * powMerge) + p1;

        System.out.println(ans);
    }
    
}
