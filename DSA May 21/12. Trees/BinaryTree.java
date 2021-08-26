import java.util.*;

public class BinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(Integer inp[]){
        Node root = new Node(inp[0],null,null); 
        int idx = 1;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,0));

        // 0 -> no child processed , 1 -> left child processed , 2 -> both child processed
        while(st.size() > 0){
            Pair top = st.peek();

            if(top.state == 0){
                Integer val = inp[idx++];
                if(val != null){
                    Node lchild = new Node(val, null, null);
                    top.node.left = lchild;
                    st.push(new Pair(lchild,0));
                }
                top.state++;
            }else if(top.state == 1){
                Integer val = inp[idx++];
                if(val != null){
                    Node rchild = new Node(val, null, null);
                    top.node.right = rchild;
                    st.push(new Pair(rchild,0));
                }
                top.state++;
            }else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = "";
        str += (node.left == null) ? "." : node.left.data;
        str += " <- "+node.data+" -> ";
        str += (node.right == null) ? "." : node.right.data;
        System.out.println(str);

        display(node.left);
        display(node.right);
    }    
    public static void main(String args[]){
        Integer inp[] = { 50 , 25 , 12 , null , null , 37 , null , null , 75 , null , 85 , null , null }; 

        Node root = construct(inp);
        display(root);
    }
}
