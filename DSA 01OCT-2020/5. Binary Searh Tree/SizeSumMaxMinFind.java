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

        Stack < Pair > st = new Stack < > ();
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
            // base case
            return 0;
        }
        int lSize = size(node.left); // left tree : number of nodes
        int rSize = size(node.right); // right tree : number of nodes
        int mySize = lSize + rSize + 1;
        return mySize;
    }

    public static int sum(Node node) {
        if(node == null){
            return 0;
        }
        int lSum = sum(node.left);
        int rSum = sum(node.right);
        int mySum = lSum + rSum + node.data;
        return mySum;
    }

    public static int max(Node node) {
        if(node == null){
            return Integer.MIN_VALUE; // root node doesn't exists
        }
        if(node.right != null){
            return max(node.right);
        }else{
            return node.data;
        }
    }

    public static int min(Node node) {
        if(node == null){
            return Integer.MAX_VALUE; // root node doesn't exists
        }
        if(node.left != null){
            return min(node.left);
        }else{
            return node.data;
        }
    }

    public static boolean find(Node node, int data) {
        if(node == null){
            // element doesn't exists
            return false;
        }else if(node.data == data){
            // element found
            return true;
        }else if(data > node.data){
            // larger elements needs to be searched
            return find(node.right,data);
        }else {
            //if(data < node.data) : smaller elements needs to be searched
            return find(node.left,data);
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
