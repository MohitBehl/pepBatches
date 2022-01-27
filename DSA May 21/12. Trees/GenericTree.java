import java.util.*;
public class GenericTree {
    public static class Node{
        int data;
        ArrayList<Node> children;

        Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    public static Node construct(int[] inp){
        if(inp.length == 0){
            return null;
        }

        Stack<Node> st = new Stack<>();
        Node root = new Node(inp[0]);
        st.push(root);

        int idx = 1;
        while(st.size() > 0){
            int vl = inp[idx++];
            if(vl == -1){
                st.pop();
            }else{
                Node node = new Node(vl);
                Node par = st.peek();
                par.children.add(node);
                st.push(node);
            }
        }

        return root;

    }

    public static void display(Node node){
        System.out.print(node.data+" -> ");
        for(Node child : node.children){
            System.out.print(child.data+" ");
        }
        System.out.println(".");

        for(Node child : node.children){
            display(child);
        }
    }
    public static void traversals(Node node){
        // pre area
        System.out.println("Node Pre "+node.data);
    
        for(Node child : node.children){
            System.out.println("Edge Pre "+node.data+"--"+child.data);// Edge Pre
            traversals(child);
            System.out.println("Edge Post "+node.data+"--"+child.data);// Edge Post
        }
        
        // post area
        System.out.println("Node Post "+node.data);
    }

    public static int size(Node node){
        int res = 0;
        for(Node child : node.chilren){
            res += size(child);
        }

        return res+1;
    }

    public static int max(Node node) {
        int res = Integer.MIN_VALUE;

        for(Node child : node.children){
            res = Math.max(res , max(child));
        }

        return Math.max(res,node.data);
    }

    public static int height(Node node) {
        int ht = -1;
        for(Node child : node.children){
            int cht = height(child);
            ht = Math.max(ht,cht);
        }

        return ht + 1;
    }

    public static void main(String[] args) {
        int[] inp = { 10 , 20 , -1 , 30 , 50 , -1 , 60 , -1 , -1 , 40 , -1 , -1 };

        Node root = construct(inp);
        display(root);
    }
}
