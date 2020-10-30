import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        printIncreasing(n); // expectation
    }

    public static void printIncreasing(int n){
        if(n == 0){
            return;
        }
        
        printIncreasing(n-1); // faith/belief
        System.out.println(n); // work
    }

}