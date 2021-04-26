import java.io.*;
import java.util.*;

public class L001 {
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
    int sizeOfLTree = size(node.left);
    int sizeOfRTree = size(node.right);
    
    return sizeOfLTree+sizeOfRTree+1;
  }

  public static int sum(Node node) {
    if(node == null){
        return 0;
    }
    int lSum = sum(node.left);
    int rSum = sum(node.right);
    
    return lSum + rSum + node.data;
  }

  public static int max(Node node) {
    if(node == null){
        return Integer.MIN_VALUE;
    }
    int lMax = max(node.left);
    int rMax = max(node.right);
    
    return Math.max(node.data,Math.max(lMax,rMax));
  }

  public static int height(Node node) {
    if(node == null){
        return -1;
    }
    int lht = height(node.left);
    int rht = height(node.right);
    return Math.max(lht,rht)+1;
  }

  public static void preorder(Node node){
      if(node == null){
          return;
      }
      System.out.print(node.data+" -> ");
      preorder(node.left);
      preorder(node.right);
  }
  public static void postorder(Node node){
    if(node == null){
        return;
    }
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.data+" -> ");
  }
  public static void inorder(Node node){
    if(node == null){
        return;
    }
    inorder(node.left);
    System.out.print(node.data+" -> ");
    inorder(node.right);
  }
  public static void traversals(Node node){
    System.out.print("pre : ");
    preorder(node);
    System.out.print(".\nin :");
    inorder(node);
    System.out.print(".\npost :");
    postorder(node);
    System.out.println(".");
  }

  public static void iterativePrePostInTraversal(Node node) {
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(node,0));
    String pre = "" , post = "" , in = "";
    while(st.size() > 0){
        Pair top = st.peek();
        
        if(top.state == 0){
            pre += top.node.data+" ";
            if(top.node.left != null){
                st.push(new Pair(top.node.left,0));
            }
            top.state++;
        }else if(top.state == 1){
            in += top.node.data+" ";
            if(top.node.right != null){
                st.push(new Pair(top.node.right,0));
            }
            top.state++;
        }else if(top.state == 2){
            post += top.node.data+" ";
            st.pop();
        }
    }
    
    System.out.println(pre+""+in+""+post);
  }

  public static boolean find(Node node, int val){
    if(node == null) return false;

    if(node.data == val) return true;
    
    if(find(node.left,val)) return true;
    
    if(find(node.right,val)) return true;
    
    return false;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int val){
    if(node == null){
        return new ArrayList<Integer>();
    }
    
    if(node.data == val){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(val);
        return al;
    }
    
    ArrayList<Integer> Lrres = nodeToRootPath(node.left,val);
    if(Lrres.size() > 0){
        Lrres.add(node.data);
        return Lrres;
    }
    
    ArrayList<Integer> Rrres = nodeToRootPath(node.right,val);
    if(Rrres.size() > 0){
        Rrres.add(node.data);
        return Rrres;
    }
    
    return new ArrayList<Integer>();
  }
  public static void printKLevelsDown(Node node, int k){
    if(node == null){
        return;
    }
    if(k == 0){
        System.out.println(node.data);
        return;
    }
    printKLevelsDown(node.left,k-1);
    printKLevelsDown(node.right,k-1);
  }

    public static ArrayList<Node> nodeToRootPath1(Node node, int data){
    if(node == null){
        return new ArrayList<>();
    }
    if(node.data == data){
        ArrayList<Node> al = new ArrayList<>();
        al.add(node);
        return al;
    }
    
    ArrayList<Node> lres = nodeToRootPath1(node.left,data);
    if(lres.size() > 0){
        lres.add(node);
        return lres;
    }
    ArrayList<Node> rres = nodeToRootPath1(node.right,data);
    if(rres.size() > 0){
        rres.add(node);
        return rres;
    }
    return new ArrayList<>();
  }

  public static void printKNodesFar(Node node, int data, int k) {
    ArrayList<Node> list = nodeToRootPath1(node,data);
    
    printKLevelsDown(list.get(0),k);
    
    for(int idx = 1 ; idx < list.size() ; idx++){
        int remDist = k - idx;
        Node curr = list.get(idx);
        Node prev = list.get(idx-1);
        if(remDist == 0){
            System.out.println(curr.data);
            break;
        }else{
            if(curr.left == prev){
                printKLevelsDown(curr.right , remDist-1);
            }else if(curr.right == prev){
                printKLevelsDown(curr.left , remDist-1);
            }
        }
    }
  }


  public static void main(String[] args) throws Exception {
    Integer inp[] = {10,20,40,null,null,50,80,null,null,null,30,60,null,90,null,null,70,null,null};
    Node root = construct(inp);
    // display(root);
    traversals(root);
  }

}