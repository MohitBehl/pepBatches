import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
      int bi = hashFunc(key);
      int idx = findKeyById(key,bi);
      
      if(idx == -1){
          // key doesn't exists
          buckets[bi].addLast(new HMNode(key,value));
          size++;
      }else{
          // key already exists
          HMNode pair = buckets[bi].get(idx);
          pair.value = value;
      }
      
      double lambda = (size*1.0)/buckets.length;
      if(lambda > 2.0){
          // rehashing
          rehash();
      }
    }

    private int hashFunc(K key){
        int uniNum = key.hashCode();
        int bi = Math.abs(uniNum%buckets.length);
        return bi;
    }

    private int findKeyById(K key , int bi){
        for(int idx = 0 ; idx < buckets[bi].size() ; idx++){
            HMNode pair = buckets[bi].get(idx);
            if(pair.key.equals(key)){
                return idx;
            }
        }
        return -1;
    }
    private void rehash() throws Exception{
        LinkedList<HMNode>[] oldBuckets = buckets;
        initbuckets(2*oldBuckets.length);
        this.size = 0;

        for(LinkedList<HMNode> list : oldBuckets){
            for(HMNode pair : list){
                put(pair.key , pair.value);
            }
        }
    }

    public V get(K key) throws Exception {
      int bi = hashFunc(key);
      int idx = findKeyById(key,bi);
      
      if(idx == -1){
          return null; // key doesn't exists
      }else{
          HMNode pair = buckets[bi].get(idx); // key already exists
          return pair.value;
      }
    }
    public boolean containsKey(K key) {
      int bi = hashFunc(key);
      int idx = findKeyById(key,bi);
      
      if(idx == -1){
          return false; // key doesn't exists
      }else{
          return true;// key already exists
      }
    }
    public V remove(K key) throws Exception {
      int bi = hashFunc(key);
      int idx = findKeyById(key,bi);
      
      if(idx == -1){
          return null; // key doesn't exists
      }else{
          HMNode pair = buckets[bi].remove(idx); // key already exists
          size--;
          return pair.value;
      }
    }

    public ArrayList<K> keyset() throws Exception {
      ArrayList<K> res = new ArrayList<>();
      for(LinkedList<HMNode> list : buckets){
          for(HMNode pair : list){
              res.add(pair.key);
          }
      }
      return res;
    }

    public int size() {
      return this.size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

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