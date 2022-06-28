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

  public static boolean find(Node node, int data){
    if(node == null){
        return false;
    }

    if(node.data == data){
        return true;
    }

    boolean lres = find(node.left, data);
    if(lres){return true;}
    boolean rres = find(node.right, data);
    return rres;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    if(node == null){
        return new ArrayList<>();
    }

    if(node.data == data){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(data);
        return list;
    }

    ArrayList<Integer> lres = nodeToRootPath(node.left, data);
    if(lres.size() > 0){
        lres.add(node.data);
        return lres;
    }
    ArrayList<Integer> rres = nodeToRootPath(node.right, data);
    if(rres.size() > 0){
        rres.add(node.data);
        return rres;
    }
    return new ArrayList<>();
  }

  
  public static void printKLevelsDown(Node node, int k){
    if(node == null) return;
    if(k == 0){
        System.out.println(node.data);
        return;
    }
    printKLevelsDown(node.left,k-1);
    printKLevelsDown(node.right,k-1);
  }
  public static void printSingleChildNodes(Node node){
    if(node == null) return;
    if(node.left != null && node.right == null){
        System.out.println(node.left.data);
    }
    if(node.left == null && node.right != null){
        System.out.println(node.right.data);
    }
    printSingleChildNodes(node.left);
    printSingleChildNodes(node.right);
  }

  public static void printSingleChildNodes(Node node, Node parent){
    if(node == null) return;

    if(parent != null){
        if(node == parent.left && parent.right == null){
            System.out.println(node.data);
        }
        if(null == parent.left && parent.right == node){
            System.out.println(node.data);
        }
    }

    printSingleChildNodes(node.left,node);
    printSingleChildNodes(node.right,node);
  }
  
  public static Node removeLeaves(Node node){
    if(node == null || (node.left == null && node.right == null)){
        return null;
    }

    node.left = removeLeaves(node.left);
    node.right = removeLeaves(node.right);

    return node;
  }

  public static class DiameterPair{
    int ht,dia;
    DiameterPair(int ht,int dia){
      this.ht = ht;
      this.dia = dia;
    }
  }
  public static DiameterPair diameter(Node node) {
    if(node == null){
      return new DiameterPair(-1,-1);
    }

    DiameterPair lpair = diameter(node.left);
    DiameterPair rpair = diameter(node.right);

    int myDia = lpair.ht + rpair.ht + 2;
    int myht = Math.max(lpair.ht,rpair.ht)+1;
    int oDia = Math.max(myDia,Math.max(lpair.dia,rpair.dia));

    return new DiameterPair(myht,oDia);
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
    boolean found = find(root, data);
    System.out.println(found);

    ArrayList<Integer> path = nodeToRootPath(root, data);
    System.out.println(path);
  }

}