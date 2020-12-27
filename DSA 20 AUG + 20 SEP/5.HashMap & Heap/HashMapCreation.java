import java.util.ArrayList;
import java.util.LinkedList;
import java.io.*;

public class HashMapCreation {
    
    public static class HashMap < K, V > {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode> buckets[]; // N = buckets.length

        // public HashMap(int capacity) {
        //     initbuckets(capacity);
        //     size = 0;
        // }

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList < > ();
            }
        }

        public void put(K key, V value) throws Exception {
            
            int bi = hashFunction(key);
            int di = getIndexInBucket(bi,key);
            
            if(di == -1){
                // value doesn't exists
                HMNode node = new HMNode(key,value);
                buckets[bi].addLast(node);
                this.size++;
            }else{
                // value already exists
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (size*1.0)/buckets.length;
            
            if(lambda > 2.0){
                rehashing();
            }
        }
        
        public V get(K key) throws Exception {
            int bi = hashFunction(key);
            int di = getIndexInBucket(bi,key);

            if(di == -1){
                return null;
            }else {
                HMNode node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = getIndexInBucket(bi,key);

            if(di == -1){
                return false;
            }else {
                return true;
            }
        }

        public V remove(K key) throws Exception {
            int bi = hashFunction(key);
            int di = getIndexInBucket(bi,key);

            if(di == -1){
                return null;
            }else {
                HMNode node = buckets[bi].remove(di);
                this.size--;
                return node.value;
            }
        }

        public ArrayList < K > keyset() throws Exception {
            ArrayList<K> list = new ArrayList<>();
            for(int idx = 0 ; idx < buckets.length ; idx++){
                for(HMNode node : buckets[idx]){
                    list.add(node.key);
                }
            }

            return list;
        }

        public int size() {
            return this.size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node: buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }

        private int hashFunction(K key){
            // hashcode
            int hc = key.hashCode();

            // abs value
            hc = Math.abs(hc);

            // in range 
            hc = hc % buckets.length;

            return hc;
        }

        private int getIndexInBucket(int bi,K key){
            int idx = 0; 
            for(HMNode node : buckets[bi]){
                if(node.key.equals(key)){
                    return idx;
                }
                idx++;
            }

            return -1;
        }

        private void rehashing() throws Exception{
            LinkedList<HMNode> oldBuckets[] = buckets;
            initbuckets(buckets.length*2);
            this.size = 0;
            
            for(int i = 0  ; i < oldBuckets.length ; i++){
                for(HMNode node : oldBuckets[i]){
                    put(node.key,node.value);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap < String, Integer > map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }   
}
