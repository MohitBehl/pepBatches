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
                // update
                hm.put(ch,hm.get(ch)+1);
            }else{
                // insert
                hm.put(ch,1);
            }
        }
        
        int maxFreq = 0;
        char maxFreqChar = ' ';
        
        for(char ch : hm.keySet()){
            int freq = hm.get(ch);
            
            if(freq > maxFreq){
                maxFreq = freq;
                maxFreqChar = ch;
            }
        }
        
        System.out.println(maxFreqChar);
    }

}