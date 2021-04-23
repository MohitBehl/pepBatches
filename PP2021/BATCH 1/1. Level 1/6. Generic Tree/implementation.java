import java.util.ArrayList;
import java.util.Stack;
public class implementation {
    public static class Node{
        int data;
        ArrayList<Node> children;
        Node(){
            children = new ArrayList<>();
        }
        Node(int data){
            this();
            this.data = data;
        }
    }
    public static Node construct(Integer input[]){
        Node root = new Node(input[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);

        for(int idx = 1 ; idx < input.length ; idx++){
            Integer val = input[idx];

            if(val == null){
                st.pop();
            }else{
                Node node = new Node(val);

                st.peek().children.add(node);
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
    public static void main(String[] args) {
        Integer input[] = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = construct(input);
        display(root);
    }
}
