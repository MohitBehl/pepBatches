public class ArrayListUsage {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        
        // System.out.println(list+" --> "+list.size());
    
        list.add(10);
        // System.out.println(list+" --> "+list.size());
        
        list.add(20);
        // System.out.println(list+" --> "+list.size());
        
        list.add(30);
        // System.out.println(list+" --> "+list.size());
        
        list.add(50);
        // System.out.println(list+" --> "+list.size());
        
        list.add(60);
        // System.out.println(list+" --> "+list.size());
        
        list.add(70);
        // System.out.println(list+" --> "+list.size());
        
        // // System.out.println(list[0]); // [index] --> not allowed
        // System.out.println(list.get(0));
        
        // System.out.println(list.get(list.size()-1));
        
        for(int idx = 0 ; idx < list.size() ; idx++){
            System.out.println(idx+"-"+list.get(idx));
        }
        
        for(int val : list){
            System.out.println(val);
        }
        
        
        System.out.println(list.remove(0));
        
        System.out.println(list);
        
        list.add(0,1000);
        
        System.out.println(list);
        
     }
}
