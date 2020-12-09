import java.util.*;

public class Main {

    public static class Node {
        int data;
        Node left; // address of left node/child
        Node right; // // address of right node/child

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static class Pair {
        Node node;
        int state;

        Pair(Node n, int s) {
            node = n;
            state = s;
        }
    }
    public static Node construct(Integer input[]) {
        int idx = 1;
        Stack < Pair > st = new Stack < > ();
        Node root = new Node(input[0]);
        st.push(new Pair(root, 1));

        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                // figure out : left child
                Integer data = input[idx];
                if (data != null) {
                    top.node.left = new Node(data);
                    st.push(new Pair(top.node.left, 1));
                } else {
                    top.node.left = null;
                }
                top.state++;
                idx++;
            } else if (top.state == 2) {
                // figure out : right child
                Integer data = input[idx];
                if (data != null) {
                    top.node.right = new Node(data);
                    st.push(new Pair(top.node.right, 1));
                } else {
                    top.node.right = null;
                }
                top.state++;
                idx++;
            } else if (top.state == 3) {
                // left + right : already figured out
                st.pop();
            }
        }
        return root;
    }
    
    public static void display(Node node){
        if(node == null){
            return;
        }
        String val = "";
        
        if(node.left == null){
            val += ".";
        }else{
            val += node.left.data;
        }
        
        val += " -> "+node.data+" <- ";
        
        if(node.right == null){
            val += ".";
        }else{
            val += node.right.data;
        }
        
        System.out.println(val);
        
        display(node.left);
        display(node.right);
        
    }

    public static int size(Node node) {
        if(node == null){
            return 0;
        }
        
        // size of left tree
        int lsize = size(node.left);
        // size of right tree
        int rsize = size(node.right);
        
        return lsize + rsize + 1;
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
        
        return Math.max(Math.max(lMax,rMax),node.data);
      }
    
      public static int height(Node node) {
        if(node == null){
            return -1;
        }
        
        int lHt = height(node.left);
        int rHt = height(node.right);
        
        int ht = Math.max(lHt,rHt)+1;
        return ht;
      }

    public static void main(String[] args) {
        Integer input[] = {
            10,
            20,
            40,
            null,
            null,
            50,
            60,
            null,
            null,
            null,
            30,
            null,
            70,
            80,
            90,
            null,
            null,
            100,
            null,
            null,
            null
        };
        
        Node root = construct(input);
        display(root);
    }
}