import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String ques = scn.nextLine();
        
        printEncodings(ques,"");
    }
    
    static char encoder[] = {' ','a','b','c','d',
                                'e','f','g','h',
                                'i','j','k','l',
                                'm','n','o','p',
                                'q','r','s','t',
                                'u','v','w','x',
                                'y','z'};
    public static void printEncodings(String qsf,String asf) {
        if(qsf.length() == 0){
            // string --> encoded
            System.out.println(asf);
            return;
        }
        
        char c1 = qsf.charAt(0); // first char of qsf
        if(c1 == '0'){
            // invalid input
            return;
        }
        
        // single digit encoding --> everytime
        printEncodings(qsf.substring(1) , asf + encoder[c1-'0']);
        
        if(qsf.length() > 1){
            // multiple digit encoding
            char c2 = qsf.charAt(1); // second of qsf
            String tmp = ""+c1+c2; // double digit number (in String)
            int num = Integer.parseInt(tmp); // double digit number (in integer)
            
            if(num >= 1 && num <= 26){
                // double digit number can be encoded
                printEncodings(qsf.substring(2),asf+encoder[num]);
            }
        }
    }

}