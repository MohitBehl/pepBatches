import java.util.*;
public class gcdAndLcm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        
        // logic
        int tn1 = num1 , tn2 = num2;
        
        while(tn1 % tn2 != 0){
            int rem = tn1%tn2;
            tn1 = tn2;
            tn2 = rem;
        }
        int gcd = tn2;
        
        int lcm = (num1*num2)/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
      }
}
