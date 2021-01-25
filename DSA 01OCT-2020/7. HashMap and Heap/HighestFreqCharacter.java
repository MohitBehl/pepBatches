import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        System.out.println(implementation1(str));
        // System.out.println(implementation2(str));
    }

    public static char implementation1(String str) {
        HashMap < Character, Integer > freqMap = new HashMap < Character, Integer > ();
        char MaxFreqChar = str.charAt(0);
        int MaxFreq = 1;
        // freqMap.get()
        // build freq. map
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (freqMap.containsKey(ch)) {
                // true : already present ,  update it's value
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                // false : new entry needs to be created
                freqMap.put(ch, 1);
            }

            if (freqMap.get(MaxFreqChar) < freqMap.get(ch)) {
                MaxFreqChar = ch;
            }
            // if(MaxFreq < freqMap.get(ch)){
            //     MaxFreqChar = ch;
            //     MaxFreq = freqMap.get(ch)
            // }
        }
        return MaxFreqChar;
    }

    public static char implementation2(String str) {
        HashMap < Character, Integer > freqMap = new HashMap < Character, Integer > ();
        char MaxFreqChar = str.charAt(0);
        // build freq. map
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (freqMap.containsKey(ch)) {
                // true : already present ,  update it's value
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                // false : new entry needs to be created
                freqMap.put(ch, 1);
            }
        }

        // find MaxFreqChar
        for (char key: freqMap.keySet()) {
            if (freqMap.get(MaxFreqChar) < freqMap.get(key)) {
                MaxFreqChar = key;
            }
        }

        return MaxFreqChar;
    }
}