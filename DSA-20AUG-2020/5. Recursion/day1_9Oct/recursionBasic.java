import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        printDecreasing(n);
    }
    
    public static void printDecreasing(int n){
        if(n == 0){
            return;
        }
        // my level work
        System.out.println(n);
        
        // faith
        printDecreasing(n-1);
    }
}