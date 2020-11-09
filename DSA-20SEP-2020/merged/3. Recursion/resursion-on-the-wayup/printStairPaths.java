import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int qsf, String path) {
        if(qsf == 0){
            System.out.println(path);
            return;
        }
        
        if(qsf-1 >= 0){
        // 1 length step
        printStairPaths(qsf-1 , path+"1");
        }
        
        if(qsf-2 >= 0){
        // 2 length step
        printStairPaths(qsf-2 , path+"2");
        }
        
        if(qsf-3 >= 0){
        // 3 length step
        printStairPaths(qsf-3 , path+"3");
        }
    }

}