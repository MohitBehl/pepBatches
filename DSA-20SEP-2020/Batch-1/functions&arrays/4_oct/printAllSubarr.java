import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int size = scn.nextInt();

        int arr[] = new int[size];

        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = scn.nextInt();
        }

        for (int sp = 0; sp < arr.length; sp++) {
            for (int ep = sp; ep < arr.length; ep++) {
                // print all elements from sp to ep
                for (int i = sp; i <= ep; i++) {
                    System.out.print(arr[i] + "\t");
                }
                System.out.println();
            }
        }
    }

}