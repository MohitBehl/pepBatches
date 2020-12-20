import java.util.*;
public class HMPractice {

    public static void HighestFrequencyCharacter(){
        Scanner scn = new Scanner(System.in);
        
        String inp = scn.nextLine();
        
        HashMap<Character,Integer> freqMap = new HashMap<>();
        
        for(int i = 0 ; i < inp.length() ; i++){
            char ch = inp.charAt(i);
            
            if(freqMap.containsKey(ch)){
                // no entry exists for this ch
                int oldFreq = freqMap.get(ch);
                freqMap.put(ch,oldFreq+1);
            }else{
                // no entry exists for this ch
                freqMap.put(ch,1);
            }
        }
        // System.out.println(freqMap);
        
        char hfCh = inp.charAt(0);
        for(char ch : freqMap.keySet()){
            if(freqMap.get(ch) > freqMap.get(hfCh)){
                hfCh = ch;
            }
        }
        
        System.out.println(hfCh);
    }
    
    
    public static void getCommonElement1(){
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int arr1[] = new int[n1];
        for(int i = 0 ; i < n1 ; i++){
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int arr2[] = new int[n2];
        for(int i = 0 ; i < n2 ; i++){
            arr2[i] = scn.nextInt();
        }

        // main logic

        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int i = 0 ; i < arr1.length ; i++){
            int val = arr1[i];
            
            if(freqMap.containsKey(val)){
                // no entry exists for this ch
                int oldFreq = freqMap.get(val);
                freqMap.put(val,oldFreq+1);
            }else{
                // no entry exists for this ch
                freqMap.put(val,1);
            }
        }

        for(int i = 0 ; i < arr2.length && freqMap.size() > 0 ; i++){
            int val = arr2[i];
            if(freqMap.containsKey(val)){
                // common element found
                System.out.println(val);
                freqMap.remove(val);
            }
        }
    }

    public static void getCommonElement2(){
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        // main logic

        HashMap < Integer, Integer > freqMap = new HashMap < > ();

        for (int i = 0; i < arr1.length; i++) {
            int val = arr1[i];

            if (freqMap.containsKey(val)) {
                // no entry exists for this ch
                int oldFreq = freqMap.get(val);
                freqMap.put(val, oldFreq + 1);
            } else {
                // no entry exists for this ch
                freqMap.put(val, 1);
            }
        }

        for (int i = 0; i < arr2.length && freqMap.size() > 0; i++) {
            int val = arr2[i];
            if (freqMap.containsKey(val)) {
                // possible common element found
                int freq = freqMap.get(val);
                if (freq > 0) {
                    System.out.println(val);
                    freqMap.put(val, freq - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        HighestFrequencyCharacter();
    }

}
