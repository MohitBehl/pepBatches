import java.util.HashMap;
public class hashMapIntro{
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();

        System.out.println(hm);

        hm.put("India",200);
        hm.put("UK",150);
        hm.put("USA",180);
        hm.put("Dubai",100);
        System.out.println(hm);
        hm.put("India",250);
        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("Pak"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Pak"));

        System.out.println(hm.keySet());

        for(String key : hm.keySet()){
            System.out.println(key +"-->"+ hm.get(key));
        }
    }
}