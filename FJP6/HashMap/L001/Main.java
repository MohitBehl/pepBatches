import java.util.HashMap;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main{
    public static void HMIntro(){
        HashMap<String,Integer> hm = new HashMap<>();
        System.out.println(hm);
        // add an ele
        hm.put("India",200);
        hm.put("China",190);
        hm.put("Uk",170);
        hm.put("USA",110);
        // System.out.println(hm);
        // // update a value
        // hm.put("India",150);
        // System.out.println(hm);
        // // key exists
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("india"));
        // // get a value
        // System.out.println(hm.get("India"));
        // System.out.println(hm.get("india"));
        // // remove a key,value
        // System.out.println(hm.remove("India")+" status -> "+hm);
        // System.out.println(hm.remove("India")+" status -> "+hm);

        for(String key : hm.keySet()){
            System.out.println("key : "+key +" val : "+hm.get(key));
        }
    }
    public static void PQIntro(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println(pq);
        pq.add(10);
        // System.out.println(pq);
        pq.add(-1);
        // System.out.println(pq);
        pq.add(2);
        // System.out.println(pq);
        pq.add(15);
        // System.out.println(pq);
        pq.add(3);
        // System.out.println(pq);
        pq.add(6);
        // System.out.println(pq);
        pq.add(4);
        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.size());

        while(pq.size() > 0){
            System.out.print(pq.remove()+" ");
        }
    }
    public static char maxFreqCh(String str){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int idx = 0 ; idx < str.length() ; idx++){
            char ch = str.charAt(idx);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1); //  update
            }else{
                hm.put(ch, 1); // add
            }
        }

        int maxFreq = 0;
        char mfch = ' ';
        for(Character ch : hm.keySet()){
            if(maxFreq < hm.get(ch)){
                maxFreq = hm.get(ch);
                mfch = ch;
            }
        }
        return mfch;
    }
    public static void solve(int n,int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < k ; i++){
            pq.add(arr[i]);
        }
        for(int i = k ; i < arr.length ; i++){
            if(arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        Stack<Integer> st = new Stack<>();
        while(pq.size() > 0){
            st.push(pq.remove());
        }
        while(st.size() > 0){
            System.out.print(st.pop()+" ");
        }
    }
    public static void main(String args[]){
        // Scanner scn = new Scanner(System.in);
        // String str = scn.nextLine();
        // char ch = maxFreqCh(str);
        // System.out.println(ch);
        
    }
}