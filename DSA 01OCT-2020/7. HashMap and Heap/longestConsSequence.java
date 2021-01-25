import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        LongestConsSeq(arr);
    }
    
    public static void LongestConsSeq(int arr[]){
        HashMap<Integer,Boolean> hm = new HashMap<>();
        
        for(int val : arr){
            hm.put(val,true);
        }
        
        for(int key : hm.keySet()){
            if(hm.containsKey(key-1)){
                hm.put(key,false);
            }
        }
        
        int LCSstartingPoint = -1;
        int LCSsize = 0;
        
        for(int key : hm.keySet()){
            if(hm.get(key)){
                int tempStartingPoint = key;
                int size = 1;
                
                while(hm.containsKey(tempStartingPoint+size)){
                    size++;
                }
                
                if(size > LCSsize){
                    LCSsize = size;
                    LCSstartingPoint = tempStartingPoint;
                }
            }
        }
        
        for(int i = 0 ; i < LCSsize ; i++){
            System.out.println(LCSstartingPoint+i);
        }
    }

}