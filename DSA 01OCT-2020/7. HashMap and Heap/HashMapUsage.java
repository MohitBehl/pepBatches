import java.util.ArrayList;
import java.util.HashMap;

public class HashMapUsage {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();

        System.out.println(hm);

        hm.put("India",250);
        hm.put("UK",350);
        hm.put("USA",450);
        hm.put("Sri Lanka",150);
        hm.put("China",400);
        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("Dubai"));

        hm.put("India",375);
        System.out.println(hm);

        System.out.println(hm.size());

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Dubai"));

        System.out.println("Special printing");
        // for(String key : hm.keySet()){
        //     System.out.println(key +" -> "+hm.get(key));
        // }        

        ArrayList<String> keys = new ArrayList<>(hm.keySet());
        System.out.println(keys);

        for(int idx = 0 ; idx < keys.size() ; idx++){
            System.out.println(keys.get(idx)+" -> "+hm.get(keys.get(idx)));
        }
    }
}
