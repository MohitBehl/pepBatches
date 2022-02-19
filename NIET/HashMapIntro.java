package NIET;

import java.util.*;
public class HashMapIntro{
    public static void main(String args[]){
        HashMap<String,Integer> hm = new HashMap<>();
        
        System.out.println(hm);

        hm.put("India",200);
        System.out.println(hm);
        hm.put("Uk",180);
        System.out.println(hm);
        hm.put("USA",120);
        System.out.println(hm);
        hm.put("Dubai",170);
        System.out.println(hm);

        hm.put("India",180);
        System.out.println(hm);

        System.out.println(hm.get("Ind"));
        // hm.remove("India");
        System.out.println(hm.remove("Ind"));

        System.out.println(hm.containsKey("India"));
        ArrayList<String> keys = new ArrayList(hm.keySet());
        System.out.println(keys);
        for(String key : hm.keySet()){
            System.out.println(key+" --> "+hm.get(key));
        }
    }
}