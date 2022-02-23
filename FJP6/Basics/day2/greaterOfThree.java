import java.util.*;
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        // if(a > b && a > c){
        //     System.out.println(a);
        // }else if(a>b b > c){
        //     System.out.println(b);
        // }else{
        //     System.out.println(c);
        // }

        if(a > b){
            // a is larger than b
            if(a > c){
                // a is larger than b as well as larger than c
                System.out.println(a);
            }else{
                // a is larger than b but c is larger than a , c > a > b
                System.out.println(c);
            }
        }else{
            // b is larger than a
            if(b > c){
                // b is larger than a as well larger than c
                System.out.println(b);
            }else{
                // b is larger than a but c is larger than b , c > b > a
                System.out.println(c);
            }
        }
    }
}