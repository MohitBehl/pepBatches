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
    if(node == null) return 0;
    return size(node.left) + size(node.right) + 1;
  }

  public static int sum(Node node) {
    if(node == null) return 0;
    return sum(node.left) + sum(node.right) + node.data;
  }

  public static int max(Node root) {
    if(root == null){
        return -1;
    }
    Node curr = root;
    while(curr.right != null){
        curr = curr.right;
    }
    return curr.data;
  }

  public static int min(Node root) {
    if(root == null){
        return -1;
    }
    Node curr = root;
    while(curr.left != null){
        curr = curr.left;
    }
    return curr.data;
  }

  public static boolean find(Node root, int data){
    Node curr = root;

    while(true){
        if(curr == null){
            return false;
        }
        if(data > curr.data){
            curr = curr.right;
        }else if(data < curr.data){
            curr = curr.left;
        }else{
            return true;
        }
    }
  }  

//   public static Node add(Node node, int data) { // recursive
//     if(node == null){
//       Node newNode = new Node(data,null,null);
//       return newNode;
//     }

//     if(data > node.data){
//       node.right = add(node.right,data);
//     }else if(data < node.data){
//       node.left = add(node.left,data);
//     }

//     return node;
//   }


   public static Node add(Node root, int data) { // iterative
    Node curr = root;
    Node par = null;
    while(true){
      if(curr == null){
          break;   
      }
      if(data == curr.data){
        // ignore
        return root;
      }else if(data > curr.data){
        par = curr;
        curr = curr.right;
      }else if(data < curr.data){
        par = curr;
        curr = curr.left;
      }
    }
    Node newnode = new Node(data,null,null);// new node 
    if(par == null){
      return newnode;
    }else if(data < par.data){
      par.left = newnode;
    }else if(data > par.data){
      par.right = newnode;
    }
    return root;
  }

  public static Node remove(Node node, int data) {
    if(node == null){
        return null;
    }

    if(data > node.data){
        node.right = remove(node.right,data);
        return node;
    }else if(data < node.data){
        node.left = remove(node.left,data);
        return node;
    }else{
        if(node.left == null && node.right == null){
            return null;// leaf
        }else if(node.left == null && node.right != null){
            return node.right; // single child
        }else if(node.left != null && node.right == null){
            return node.left; // single child
        }else{
            int mval = max(node.left);
            node.data = mval;
            node.left = remove(node.left,mval);
            return node;
        }
    }
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