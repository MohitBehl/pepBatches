package NIET;

import java.util.ArrayList;
import java.util.Stack;

public class GTIntro{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
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
    public static Node construct(int input[]){
        Stack<Node> st = new Stack<>();
        Node root = new Node(input[0]);
        st.push(root);
        for(int idx = 1 ; idx < input.length ; idx++){
            int val = input[idx];

            if(val == -1){
                st.pop();
            }else{
                Node node = new Node(val);
                st.peek().children.add(node);
                st.push(node);
            }
        }
        return root;
    }
    public static void main(String args[]){
        int input[] = {10 , 20, -1,30,40,50,60,-1,-1,-1,70,-1,-1,90,100,110,140,-1,-1,120,130,-1,-1,-1,-1,-1};

        Node root = construct(input);
    }
}