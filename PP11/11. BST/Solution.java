public class Solution {
    public static class Node{
        int data;
        Node left,right;
        Node(){

        }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int arr[],int lo,int hi){
        if(lo > hi){
            return null;
        }
        int mid = (lo+hi)/2;
        Node node = new Node();
        node.data = arr[mid];

        node.left = construct(arr, lo, mid-1);
        node.right = construct(arr, mid+1 , hi);

        return node;
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
        if(node.right == null){
            return node.data;
        }else{
            return max(node.right);
        }
    }

    public static int min(Node node) {
        if(node.left == null){
            return node.data;
        }else{
            return min(node.left);
        }
    }

    static int sum = 0;
    public static void rwsol(Node node){
        if(node == null){
            return;
        }
        rwsol(node.right);
        
        // reverse inorder
        int val = node.data;
        node.data = sum;
        sum += val;
        
        rwsol(node.left);
    }

    public static boolean find(Node node, int data){
        if(node == null) return false;
        if(node.data == data) return true;

        if(data < node.data){
            return find(node.left,data);
        }else{
            return find(node.right,data);
        }
    } 

    public static Node add(Node node, int data) {
        if(node == null){
            Node newnode = new Node(data,null,null);
            return newnode;
        }

        if(data == node.data){
            return node;
        }else if(data > node.data){
            node.right = add(node.right,data);
            return node;
        }else{
            node.left = add(node.left, data);
            return node;
        }
    }

    public static Node remove(Node node, int data) {
        if(node == null){
            return null;
        }
        if(data < node.data){
            node.left = remove(node.left,data);
            return node;
        }else if(data > node.data){
            node.right = remove(node.right,data);
            return node;
        }else{
            if(node.left == null && node.right == null){ // leaf node
                return null;
            }else if(node.left == null){ // single child : right child exists
                Node rep = node.right;
                node.right = null;
                return rep;
            }else if(node.right == null){ // single child : left child exists
                Node rep = node.left;
                node.left = null;
                return rep;
            }else{ // both child exists
                int max = max(node.left);
                node.data = max;
                remove(node.left,max);
                return node;
            }
        }
        
    }
    public static void tsp(Node node,int target,Node root){
        if(node == null){
            return;
        }
        tsp(node.left,target,root);
        
        int cval = target-node.data;
        if(cval > node.data && find(root,cval)){
            System.out.println(node.data +" "+cval);
        }
        
        tsp(node.right,target,root);
    }
    public static void display(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.left == null ? "." : node.left.data);
        System.out.print(" <- "+node.data+" -> ");
        System.out.println(node.right == null ? "." : node.right.data);

        display(node.left);
        display(node.right);
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60,70}; // sorted integers

        Node root = construct(arr, 0, arr.length-1);
        display(root);
        // tsp(root,data,root);
    }
}
