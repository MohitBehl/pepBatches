import java.util.HashMap;

public class HM {
    public static void main(String argsp []){
        HashMap<String,Integer> hm = new HashMap<>();

        System.out.println(hm);

        hm.put("India" , 200);
        hm.put("USA" , 250);
        hm.put("China" , 140);
        hm.put("UK" , 190);
        hm.put("Dubai" , 210);

        System.out.println(hm);
        
        System.out.println("India : "+ hm.get("India"));
        System.out.println("india : "+ hm.get("india"));

        hm.put("France" , 175);
        System.out.println(hm);

        hm.put("India" , 199);
        System.out.println(hm);

        Integer tmp = hm.remove("India");
        System.out.println(hm);
        System.out.println(tmp);

        tmp = hm.remove("Utopia");
        System.out.println(tmp);

        System.out.println(hm.containsKey("USA"));
        System.out.println(hm.containsKey("Utopia"));

        // System.out.println(hm.keySet());

        // Set -> ArrayList
        // ArrayList<String> list = new ArrayList<>(hm.keySet());
        // System.out.println(list);

        for(String key : hm.keySet()){
            System.out.println(key + " --> "+hm.get(key));
        }
        
    }
}
