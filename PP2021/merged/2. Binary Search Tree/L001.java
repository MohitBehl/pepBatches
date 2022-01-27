import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int size(Node node) {
    if(node == null){
        return 0;
    }
    return size(node.left) + size(node.right) + 1;
  }

  public static int sum(Node node) {
    if(node == null){
        return 0;
    }
    return sum(node.left) + sum(node.right) + node.data;
  }

  public static int max(Node node) {
    if(node.right != null){
        return max(node.right);
    }else{
        return node.data;
    }
  }

  public static int min(Node node) {
    if(node.left != null){
        return min(node.left);
    }else{
        return node.data;
    }
  }

  public static boolean find(Node node, int data){
    if(node == null){
        return false;
    }
    if(data > node.data){
        return find(node.right,data);
    }else if(data < node.data){
        return find(node.left,data);
    }else{
        return true;
    }
  }  

  public static Node remove(Node node, int data) {
    if(node == null){
        return null;
    }
   if(data < node.data){
       node.left = remove(node.left,data);
       return node;
   }else if(data > node.data){
       node.right = remove(node.right,data);
       return node;
   }else{
       if(node.left == null && node.right == null){
           // leaf node
           return null;
       }else if(node.left == null){
           // right child exists
           Node tmp = node.right;
           node.right = null;
           return tmp;
       }else if(node.right == null){
           // left child exists
           Node tmp = node.left;
           node.left = null;
           return tmp;
       }else{
           // both left & right child exists
           int val = max(node.left);
           node.data = val;
           node.left = remove(node.left,val);
           return node;
       }
   }
 }

 public static int lca(Node node, int d1, int d2) {
    if(d1 < node.data && d2 < node.data){
        return lca(node.left,d1,d2);
    }else if(d1 > node.data && d2 > node.data){
        return lca(node.right,d1,d2);
    }else{
        return node.data;
    }
  }

public static void pir(Node node, int d1, int d2) {
    if(node == null){
        return;
    }
  if(d1 < node.data && d2 < node.data){
      pir(node.left,d1,d2);
  }else if(d1 > node.data && d2 > node.data){
      pir(node.right,d1,d2);
  }else{
      pir(node.left,d1,d2);
      System.out.println(node.data);
      pir(node.right,d1,d2);
  }
}

public static Node add(Node node, int data) {
    if(node == null){
        return new Node(data,null,null);
    }
    if(data < node.data){
        node.left = add(node.left,data);
    }else if(data >  node.data){
        node.right = add(node.right,data);
    }
    
    return node;
  }
  public static void tsp(Node node,int target,Node root){
    if(node == null){
        return;
    }
    tsp(node.left,target,root);
    
    int comp = target - node.data;
    if(comp > node.data && find(root,comp)){
        System.out.println(node.data+" "+comp);
    }
    
    tsp(node.right,target,root);
}
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);

    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int min = min(root);
    boolean found = find(root, data);

    System.out.println(size);
    System.out.println(sum);
    System.out.println(max);
    System.out.println(min);
    System.out.println(found);
  }

}