import java.util.*;
public class Main {
    private static class Node{
        int data;
        ArrayList<Node> children;
        Node(int val){
            data = val;
            children = new ArrayList<>();
        }
    }
    public static Node constructGT(Integer arr[]){
        Stack<Node> st = new Stack<>();
        Node root = new Node(arr[0]);
        st.push(root);
        int idx = 1;
        while(idx < arr.length){
            Integer vl = arr[idx];
            if(vl == null){
                st.pop();
            }else{
                Node node = new Node(vl);
                Node par = st.peek();
                par.children.add(node); // link
                st.push(node);
            }
            idx++;
        }
        return root;
    }
    public static void display(Node node){
        System.out.print(node.data+" -> ");
        for(Node child : node.children){
            System.out.print(child.data+" ");
        }
        System.out.println();

        for(Node child : node.children){
            display(child);
        }
    }
     public static int size(Node node){
        int ans = 0;
        for(Node child : node.children){
            ans += size(child);
        }

        return ans+1;
    }
    public static void main(String args[]){
        Integer arr[] = {10,20,null,30,50,null,60,null,null,40,null,null};
        Node root = constructGT(arr);
        display(root);
    }
}
