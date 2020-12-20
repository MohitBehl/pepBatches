import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String,Integer> hm = new HashMap<>();
        System.out.println(hm);
        
        hm.put("India",220);
        System.out.println(hm);
        
        hm.put("USA",450);
        System.out.println(hm);
        
        hm.put("China",390);
        System.out.println(hm);
        
        hm.put("UK",400);
        System.out.println(hm);
        
        hm.put("India",300);
        System.out.println(hm);
        
        for(String key : hm.keySet()){
          System.out.println(key);   
        }
        
        System.out.println(hm.get("UK"));
        
        System.out.println(hm.get("Russia"));
        
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Dubai"));
    }
}