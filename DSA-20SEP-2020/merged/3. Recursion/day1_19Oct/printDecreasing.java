import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();

        printDec(n);
    }
    
    // printDec(n) ==> expectation
    public static void printDec(int n){
        if(n == 0){
            return;    
        }
        
        System.out.println(n);
        
        printDec(n-1); // faith
        
    }
}