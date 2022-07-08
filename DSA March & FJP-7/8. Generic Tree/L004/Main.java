import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
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


  static int ans;

  public static int diameter(Node node){
    int lh = -1;
    int slh = -1;
    
    for(Node child : node.children){
      int cht = diameter(child);
      if(cht > lh){
        slh = lh;
        lh = cht;
      }else if(cht > slh){
        slh = cht;
      }
    }

    int dia = lh + slh + 2; // dia of node
    ans = Math.max(ans,dia);
    return lh+1;
  }

  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data > data){ // larger
      if(node.data < ceil){
        ceil = node.data;
      }
    }
    if(node.data < data){ // smaller
      if(node.data > floor){
        floor = node.data;
      }
    }

    for(Node child : node.children){
      ceilAndFloor(child,data);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);

    // ceil = Integer.MAX_VALUE;
    // floor = Integer.MIN_VALUE;
    // ceilAndFloor(root, data);
    // System.out.println("CEIL = " + ceil);
    // System.out.println("FLOOR = " + floor);

    ans = 0;// static 
    diameter(root); 
    System.out.println(ans);
  }

}