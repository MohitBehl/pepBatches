import java.util.*;
public class Main{
    public static class Node{
        int data;
        Node left,right;
        Node(int val){
            data = val;
            left = right = null;
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node){
            this.node = node;
        }
    }
    public static Node construct(Integer arr[]){
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root));
        int idx = 1;
        while(st.size() > 0){
            Pair tpair = st.peek();
            if(tpair.state == 0){
                Integer vl = arr[idx++];
                if(vl != null){
                    Node newnode = new Node(vl); // create
                    tpair.node.left = newnode; // connect to left
                    st.push(new Pair(newnode)); // push to stack
                }
                tpair.state++;
            }else if(tpair.state == 1){
                Integer vl = arr[idx++];
                if(vl != null){
                    Node newnode = new Node(vl); // create
                    tpair.node.right = newnode; // connect to right
                    st.push(new Pair(newnode)); // push to stack
                }
                tpair.state++;
            }else{ //tpair.state == 2
                st.pop();
            }
        }
        return root;
    }
    static int idx;
    public static Node construct1(Integer arr[]){ //  construct -> recursion
        if(arr[idx] == null){
            idx++;
            return null;
        }    
        Node node = new Node(arr[idx++]);
        node.left = construct1(arr);
        node.right = construct1(arr);
        return node;
    }
    public static void display(Node node){
        if(node == null) return;

        if(node.left != null) System.out.print(node.left.data);
        System.out.print(" <- "+node.data+" -> ");
        if(node.right != null) System.out.print(node.right.data);
        System.out.println();

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if(node == null) return 0;
        // int lsize = size(node.left);
        // int rsize = size(node.right);
        // return lsize + rsize + 1;
        return size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node) {
        if(node == null) return 0;
        return sum(node.left) + sum(node.right) + node.data;
    }

    public static int max(Node node) {
        if(node == null) return Integer.MIN_VALUE;
        return Math.max( Math.max( max(node.left) , max(node.right) ) , node.data );
    }

    public static int height(Node node) {
        if(node == null) return -1;
        return Math.max( height(node.left) , height(node.right) ) + 1;
    }
    public static void main(String args[]){
        Integer arr[] = {10,20,40,null,null,50,70,null,null,null,30,null,60,null,null};
        // Node root = construct(arr);
        // idx = 0;
        // Node root = construct1(arr);
        display(root);
    }
}