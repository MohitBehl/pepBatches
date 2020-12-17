import java.util.*;

public class Main{

    public static class Node{
        int data;
        Node left;
        Node right;
    }
    
    public static Node construct(int input[],int lo,int hi){
        if(lo > hi){
            return null;
        }
        int mid = (lo + hi)/2;
        Node node = new Node();
        node.data = input[mid];

        node.left = construct(input,lo,mid-1);
        node.right = construct(input,mid+1,hi);

        return node;
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int lsize = size(node.left);
        int rsize = size(node.right);

        return lsize + rsize + 1;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int lsum = sum(node.left);
        int rsum = sum(node.right);

        return lsum + rsum + node.data;
    }

    public static int max(Node node) {
        if (node.right == null) {
            return node.data;
        } else {
            return max(node.right);
        }
    }

    public static int min(Node node) {
        if (node.left == null) {
            return node.data;
        } else {
            return min(node.left);
        }
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            // element doesn't exists
            return false;
        }
        if (node.data == data) {
            return true;
        } else if (data < node.data) {
            // smaller area
            return find(node.left, data);
        } else  {
            // larger area
            return find(node.right, data);
        }
    }
    public static Node add(Node node, int data) {
        if(node == null){
            Node bnode = new Node(data,null,null);
            return bnode; 
        }
        
        if(data < node.data){
            // smaller
            node.left = add(node.left,data);
        }else if(data > node.data){
            node.right = add(node.right,data);
        }
        
        return node;
      }

      public static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = remove(node.left, data);
        } else if (data > node.data) {
            node.right = remove(node.right, data);
        } else {
            // node found
            if (node.left == null && node.right == null) {
                // leaf node is about to be removed
                return null;
            } else if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {
                // node.left != null && node.right != null
                int maxVal = max(node.left);
                node.data = maxVal;
                node.left = remove(node.left,maxVal);
            }
        }
        return node;
    }
    public static void display(Node node){
        if(node == null){
            return;
        }
        String val = "";
        
        if(node.left == null){
            val += ".";
        }else{
            val += node.left.data;
        }
        
        val += " -> "+node.data+" <- ";
        
        if(node.right == null){
            val += ".";
        }else{
            val += node.right.data;
        }
        
        System.out.println(val);
        
        display(node.left);
        display(node.right);
        
    }
    public static void main(String[] args) {
        int input[] = {10,20,30,40,50,60,70,80,90,100};

        Node root = construct(input,0,input.length-1);
        display(root);
    }
}