import java.util.*;

public class Main{

public static void main(String[] args) {

    // Integer , Double , Float , Character , Boolean , String 
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    System.out.println(list +" : " +list.size());
    
    // add
    list.add(10);
    list.add(90);
    list.add(101);
    System.out.println(list +" : " +list.size());
    
    // remove
    list.remove(1);
    System.out.println(list +" : " +list.size());
    
    // insert
    list.add(2,1000);
    System.out.println(list +" : " +list.size());

    list.add(45);
    list.add(70);
    list.add(79);
    System.out.println(list +" : " +list.size());
    
    // get --> donot use [idx]
    int val = list.get(3);
    System.out.println(list +" : " +list.size()+" val : "+val);
    
    // update / set
    
    list.set(0,-99);
    System.out.println(list +" : " +list.size());
    
    
    for(int idx = 0 ; idx < list.size() ; idx++){
        System.out.println("idx -> "+list.get(idx));
    }
    
    for(int v : list){
        System.out.println(v);
    }
    
 }
}