import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String ques = scn.nextLine();
        
        printKPC(ques,"");
    }
    
    static String keypad[] = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    public static void printKPC(String qsf,String asf){
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        
        char ch  = qsf.charAt(0);
        int key = ch-'0';
        
        String word = keypad[key];
        String roq = qsf.substring(1);
        
        for(int i = 0 ; i < word.length() ; i++){
            printKPC(roq , asf+word.charAt(i));
        }
    }

}