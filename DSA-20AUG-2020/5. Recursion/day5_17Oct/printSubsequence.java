import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        
        printSS(str,"");
    }

    public static void printSS(String qsf , String asf) {
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        char ch = qsf.charAt(0);
        String ros = qsf.substring(1);
        
        // included
        printSS(ros,asf+ch);
        // not included
        printSS(ros,asf);
    }

}