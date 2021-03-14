import java.io.*;
import java.util.*;
import java.lang.*;
public class Main{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
    public static Node construct(int[] arr) {
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
    }

    public static class GenericTree implements Iterable{
        Node root;
        
        GenericTree(Node root){
            this.root = root;
        }

        public Iterator<Integer> iterator(){
            Iterator<Integer> obj = new GenericTreeIterator(root);
            return obj;
        }
    }

    public static class GenericTreeIterator implements Iterator<Integer>{
        Integer nval;
        Stack<Pair> st = new Stack<>();

        GenericTreeIterator(Node root){
            // nval = null;
            st.push(new Pair(root,-1));
            next();
        }

        public boolean hasNext(){
            if(nval == null){
                return false;
            }else{
                return true;
            }
        }
        
        public Integer next(){
            int retVal = nval == null ? 0 : nval;
            nval = null;
            while(st.size() > 0){
                Pair top = st.peek();
                
                if(top.state == -1){        
                    top.state++;
                    nval = top.node.data;
                    break;
                }else if(top.state == top.node.children.size()){
                    st.pop();
                }else{
                    Node child = top.node.children.get(top.state);
                    Pair pair = new Pair(child,-1);
                    st.push(pair);
                    top.state++;
                }
            }
            return retVal;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);

        GenericTree gt = new GenericTree(root);

        // for(Integer val : gt){ //  values in preorder
        //     System.out.println(val);
        // }

        Iterator<Integer>obj = gt.iterator();
        while(obj.hasNext() == true){
            Integer val = obj.next();
            System.out.print(val+" ");
        }

    }
}
/*
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
*/