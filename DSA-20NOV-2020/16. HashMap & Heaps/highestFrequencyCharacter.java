import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        String inp = scn.nextLine();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int idx = 0 ; idx < inp.length() ; idx++){
            char ch = inp.charAt(idx);
            
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }
        }
        
        int max = 0;
        char ch = ' ';
        
        for(char key : hm.keySet()){
            if(hm.get(key) > max){
                max = hm.get(key);
                ch = key;
            }
        }
        
        System.out.println(ch);
    }

}