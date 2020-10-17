import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String ques = scn.nextLine();
        
        printPermutations(ques,"");
    }

    public static void printPermutations(String qsf,String asf) {
        
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        
        for(int i = 0  ; i < qsf.length() ; i++){
            char ch = qsf.charAt(i);
            String roq = qsf.substring(0,i) + qsf.substring(i+1);
            printPermutations(roq,asf+ch);
        }
    }

}