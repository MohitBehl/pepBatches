import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Declaration
        ArrayList < Integer > list = new ArrayList < Integer > ();
        
        // size
        System.out.println(list.size());

        // printing
        System.out.println(list +" size: "+list.size());
        
        // addLast --> add(ele);
        list.add(10);
        System.out.println(list +" size: "+list.size());
        
        list.add(20);
        System.out.println(list +" size: "+list.size());
        
        list.add(30);
        System.out.println(list +" size: "+list.size());
        
        list.add(40);
        System.out.println(list +" size: "+list.size());
        
        // addSpecific --> add(idx,ele);
        list.add(2,100);
        System.out.println(list +" size: "+list.size());
        
        list.add(list.size() , -99);
        System.out.println(list +" size: "+list.size());
        
        // get(idx) --> [idx](not allowed)
        System.out.println(list.get(4));
        
        // update --> set(idx,ele);
        list.set(0,-1);
        System.out.println(list +" size: "+list.size());
        
        // remove(idx) --> delete element
        list.remove(0);
        System.out.println(list +" size: "+list.size());
        
        // for
        for(int i = 0 ; i < list.size() ; i++){
            int val = list.get(i);
            System.out.println(i+" --> "+val);
        }
        
        // for-each
        for(int val : list){
            System.out.println(val);
        }
    }
}