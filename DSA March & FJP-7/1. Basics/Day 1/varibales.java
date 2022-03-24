    import java.util.*;

public class Main {

    public static void main(String[] args) {
        int v1; // declaration
        v1 = 11; // initialize

        int v2 = 10;

        // int add = v1 + v2;
        // int sub = v1 - v2;
        // int mul = v1 * v2;
        // int div = v1 / v2;
        // int mod = v1 % v2;

        // System.out.println("v1 : "+v1+" v2 : "+v2);
        // System.out.println("add : "+add);
        // System.out.println("sub : "+sub);
        // System.out.println("mul : "+mul);
        // System.out.println("div : "+div);
        // System.out.println("mod : "+mod);

        boolean isEven = (v1%2 == 0);
        boolean check1 = (v1 > v2);
        boolean check2 = (v1 >= v2);
        boolean check3 = (v1 < v2);
        boolean check4 = (v1 <= v2);
        System.out.println(isEven);
        System.out.println(check1);
        System.out.println(check2);
        System.out.println(check3);
        System.out.println(check4);
    }
}