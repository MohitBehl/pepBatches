import java.util.Stack;
public class BSTIntro {
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
        Stack<Pair> st = new Stack<>();

        Node root = new Node(inp[0],null,null);
        st.push(new Pair(root,0));
        int idx = 1;
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 0){
                Integer ele = inp[idx];
                if(ele != null){
                    Node newNode = new Node(ele,null,null);
                    top.node.left = newNode;
                    st.push(new Pair(newNode,0));
                }
                idx++;
                top.state++;
            }else if(top.state == 1){
                Integer ele = inp[idx];
                if(ele != null){
                    Node newNode = new Node(ele,null,null);
                    top.node.right = newNode;
                    st.push(new Pair(newNode,0));
                }
                idx++;
                top.state++;
            }else{
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
        str += node.left != null ? node.left.data : ".";
        str += " <- "+node.data+" -> ";
        str += node.right != null ? node.right.data : ".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static void main(String[] args) {
        Integer inp[] = {10,20,40,null,null,50,80,null,null,null,30,60,null,90,null,null,70,null,null};
        Node root = construct(inp);
        display(root);
    }
}
