import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args){     
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int arr1[] = new int[n1];
        for(int idx = 0 ; idx < n1 ; idx++){
            arr1[idx] = scn.nextInt();
        }
        
        int n2 = scn.nextInt();
        int arr2[] = new int[n2];
        for(int idx = 0 ; idx < n2 ; idx++){
            arr2[idx] = scn.nextInt();
        }
        
        HashMap<Integer,Boolean> hm = new HashMap<>();
        
        for(int val : arr1){
            hm.put(val,true);
        }
        
        for(int val : arr2){
            if(hm.containsKey(val)){
                System.out.println(val);
                hm.remove(val);
            }
        }
    }

}