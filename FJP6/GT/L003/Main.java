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

  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

  public static int lca(Node root, int d1, int d2) {
    ArrayList<Integer> path1 = nodeToRootPath(root,d1);
    ArrayList<Integer> path2 = nodeToRootPath(root,d2);

    int i = path1.size()-1 , j = path2.size()-1;

    while(i >= 0 && j >= 0){
      if(path1.get(i) == path2.get(j)){
        i--;
        j--;
      }else{
        break;
      }
    }

    return path2.get(j+1);
  }
    public static Node getTailNode(Node node){
        while(node.children.size() != 0){
            node = node.children.get(0);
        }
        return node;
    }
    public static void linearize(Node node){
        for(Node child : node.children){
            linearize(child);
        }

        while(node.children.size() > 1){
            Node lc = node.children.get(node.children.size()-1);
            Node slc = node.children.get(node.children.size()-2);
            node.children.remove(node.children.size()-1);
            Node tailNode = getTailNode(slc);
            tailNode.children.add(lc);
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

    int d1 = Integer.parseInt(br.readLine());
    int d2 = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int lca = lca(root, d1, d2);
    System.out.println(lca);
    // display(root);
  }

}