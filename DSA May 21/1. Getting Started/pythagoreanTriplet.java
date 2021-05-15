import java.util.*;
public class pythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        
        // a is largest side
        boolean exp1 = ((a*a) == ((b*b)+(c*c)));
        
        // b is largest side
        boolean exp2 = ((b*b) == ((a*a)+(c*c)));
        
        // c is largest side
        boolean exp3 = ((c*c) == ((b*b)+(a*a)));
        
        boolean isTriplet = exp1 || exp2 || exp3;
        
        System.out.println(isTriplet);
       }
}
