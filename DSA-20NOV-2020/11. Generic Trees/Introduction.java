import java.util.*;

public class Main {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
    public static Node Construct(Integer input[]){
        Node root = new Node();
        root.data = input[0];
        Stack<Node> st = new Stack<>();
        st.push(root);
        for(int idx = 1 ; idx < input.length ; idx++){
            Integer val = input[idx];
            if(val == null){
                st.pop();
            }else{
                Node node = new Node();
                node.data = val;
                st.peek().children.add(node);
                st.push(node);
            }
        }
        return root;
    }
    
    public static void display(Node node){
        // self printing 
        System.out.print(node.data+"->");
        for(Node childNode : node.children){
            System.out.print(childNode.data+" ");
        }
        System.out.println(".");
        
        for(Node childNode : node.children){
            display(childNode);
        }
    }
    public static int size(Node node){
        int ans = 0;
        for(Node child : node.children){
            ans += size(child);
        }
        ans += 1;
        return ans;
    }
    
    public static void main(String[] args) {
        Integer input[] = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = Construct(input);
        System.out.println(root.data);
        display(root);
    }
}
