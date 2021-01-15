public class Intro{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this(data,null,null);
        }
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node construct(int arr[]){
        return constructHelper(arr, 0, arr.length-1);
    }
    public static Node constructHelper(int arr[],int lo,int hi){
        if(lo > hi){
            return null;
        }
        int mid = (lo+hi)/2; // node-index
        Node node = new Node(arr[mid]);
        node.left = constructHelper(arr, lo, mid-1); // left region
        node.right = constructHelper(arr, mid+1, hi); // right region
        return node;
    }
    public static void display(Node node){
        if(node == null){
            return;
        }
        // my work
        String str = "";
        str += (node.left != null) ? node.left.data : "."; // for left 
        str += " <- "+node.data+" -> "; // for self
        str += (node.right != null) ? node.right.data : "."; // for right
        System.out.println(str);
        
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        int arr[] = {12,25,30,50,60,75,87};

        Node root = construct(arr);
        display(root);
    }
}