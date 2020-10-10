import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        pdi(n);
    }

    public static void pdi(int n){
        if(n == 0){
            return;
        }
        System.out.println(n); // extra work
        pdi(n-1); // faith
        System.out.println(n); // extra work
    }

}