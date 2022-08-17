import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int aPlusCount = 0;
        int abPlusCount = 0; 
        int abcPlusCount = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == 'a'){
                aPlusCount = 2*aPlusCount + 1;
            }else if(ch == 'b'){
                abPlusCount = 2*abPlusCount + aPlusCount;
            }else if(ch == 'c'){
                abcPlusCount = 2*abcPlusCount + abPlusCount;
            }
        }

        System.out.println(abcPlusCount);
    }
}