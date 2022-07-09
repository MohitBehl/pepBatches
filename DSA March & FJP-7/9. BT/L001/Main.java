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
    public static void display(Node node){
        if(node == null) return;

        if(node.left != null) System.out.print(node.left.data);
        System.out.print(" <- "+node.data+" -> ");
        if(node.right != null) System.out.print(node.right.data);
        System.out.println();

        display(node.left);
        display(node.right);
    }
    public static void main(String args[]){
        Integer arr[] = {10,20,40,null,null,50,70,null,null,null,30,null,60,null,null};
        Node root = construct(arr);
        display(root);
    }
}