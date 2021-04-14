import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = scn.nextInt();
    }
    
    HashMap<Integer,Boolean> hm = new HashMap<>();
    
    for(int ele : arr){
        hm.put(ele,true);
    }
    
    for(int ele : hm.keySet()){
        if(hm.containsKey(ele-1)){
            hm.put(ele,false);
        }
    }
    
    int sp = -1 , cSeq = -1;
    for(int ele : hm.keySet()){
        if(hm.get(ele)){
            int count = 1;
            while(hm.containsKey(ele+count)){
                count++;
            }
            
            if(count > cSeq){
                sp = ele;
                cSeq = count;
            }
        }
    }
    
    for(int i = 0 ; i < cSeq ; i++){
        System.out.println(sp+i);
    }
 }

}