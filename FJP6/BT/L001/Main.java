import java.util.*;
public class Main{
    public static class Node{
        int data;
        Node left , right;
        Node(int val){
            this.data = val;
            left = right = null;
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node){
            this.node = node;
            this.state = 0;
        }
    }
    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root));
        int idx = 1;
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 0){
                Integer val = arr[idx];
                if(val != null){
                    Node child = new Node(val);
                    top.node.left = child;
                    st.push(new Pair(child));
                }
                top.state++;
                idx++;
            }else if(top.state == 1){
                Integer val = arr[idx];
                if(val != null){
                    Node child = new Node(val);
                    top.node.right = child;
                    st.push(new Pair(child));
                }
                top.state++;
                idx++;
            }else if(top.state == 2){
                st.pop();
            }
        }
        return root;
    }
    public static void display(Node node){
        if(node == null)return;
        System.out.print(node.left == null ? "." : node.left.data);
        System.out.print(" <- "+node.data+" -> ");
        System.out.println(node.right == null ? "." : node.right.data);

        display(node.left);
        display(node.right);        
    }
    public static int size(Node node) {
        if(node == null){
            return 0;
        }
        int lsize = size(node.left);
        int rsize = size(node.right);
        return lsize + rsize + 1;
    }

    public static int sum(Node node) {
        if(node == null){
            return 0;
        }
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        return lsum + rsum + node.data;
    }

    public static int max(Node node) {
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lmax = max(node.left);
        int rmax = max(node.right);

        return Math.max(Math.max(lmax,rmax) , node.data);
    }

    public static int height(Node node) {
        if(node == null){
            return -1;
        }
        int lht = height(node.left);
        int rht = height(node.right);

        return Math.max(lht,rht)+1;
    }
    public static void main(String args[]){
        Integer arr[] = {10,20,40,60,null,null,null,50,70,null,null,80,null,null,30,null,90,100,null,null,null};
        Node root = construct(arr);
        display(root);
    }
}