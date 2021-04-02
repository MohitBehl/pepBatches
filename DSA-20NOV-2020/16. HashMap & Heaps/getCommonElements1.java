import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    
    int n1 = scn.nextInt();
    int arr1[] = new int[n1];
    for(int idx = 0 ; idx < arr1.length ; idx++){
        arr1[idx] = scn.nextInt();
    }
    
    int n2 = scn.nextInt();
    int arr2[] = new int[n2];
    for(int idx = 0 ; idx < arr2.length ; idx++){
        arr2[idx] = scn.nextInt();
    }
    
    // logic
    HashMap<Integer,Boolean> hm = new HashMap<>();
    
    for(int ele : arr1){
        hm.put(ele,true);
    }
    
    for(int ele : arr2){
        if(hm.containsKey(ele) && hm.get(ele)){
            System.out.println(ele);
            hm.put(ele,false);
        }
    }
 }

}