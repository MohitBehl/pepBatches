public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node construct(int []inp,int lo,int hi){
        if(lo > hi){
            return null;
        }        
        int mid = (lo+hi)/2;
        Node node = new Node(inp[mid]);

        node.left = construct(inp, lo, mid-1);
        node.right = construct(inp, mid+1, hi);

        return node;
    }

    public static void display(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.left == null ? ".":root.left.data);
        System.out.print(" <- "+root.data+" -> ");
        System.out.print(root.right == null ? ".":root.right.data);
        System.out.println();

        display(root.left);
        display(root.right);
    }
    
    public static int size(Node node) {
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        
        return ls+rs+1;
    }

    public static int sum(Node node) {
        if(node == null){
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        
        return ls+rs+node.data;
    }

    public static int max(Node node) {
        if(node.right == null){
            return node.data;
        }
        
        return max(node.right);
    }

    public static int min(Node node) {
        if(node.left == null){
            return node.data;
        }
        
        return min(node.left);
    }

    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        
        if(node.data == data){
            return true;
        }else if(data > node.data){ // larger - > right
            return find(node.right,data);
        }else{ // smaller - > left
            return find(node.left,data);
        }
    }  
    
    public static Node add(Node node, int data) {
        if(node == null){
            return new Node(data,null,null);
        }
        
        if(data > node.data){
            node.right = add(node.right,data);
        }else if(data < node.data){
            node.left = add(node.left,data);
        }
        
        return node;
    }

    public static Node remove(Node node, int data) {
        if(data > node.data){
            node.right = remove(node.right,data);
        }else if(data < node.data){
            node.left = remove(node.left,data);
        }else{
            Node lchild = node.left;
            Node rchild = node.right;
            
            if(lchild == null && rchild == null){ // no child
                return null;
            }else if(lchild != null && rchild == null){ // only left child
                return node.left;
            }else if(lchild == null && rchild != null){ // only right child 
                return node.right;
            }else{ //both child
                int max = max(lchild);
                node.data = max;
                node.left = remove(lchild,max);
                return node;
            }
        }
        
        return node;
    }

    static int sum = 0;
    public static void rwsol(Node node){
        if(node == null){
            return;
        }
        rwsol(node.right);
        
        int tmp = node.data;
        node.data = sum;
        sum += tmp;
        
        rwsol(node.left);
    }


    public static int lca(Node node, int d1, int d2) {
        if(d1 < node.data && d2 < node.data){
            return lca(node.left,d1,d2);
        }else if(d1 > node.data && d2 > node.data){
            return lca(node.right,d1,d2);
        }else{
            return node.data;
        }
    }

    public static void tsp(Node node,Node root,int total){
        if(node == null){
            return;
        }
        
        tsp(node.left,root,total);
        
        int val = node.data;
        int cval = total - node.data;
        if(val < cval && find(root,cval)){
            System.out.println(val+" "+cval);
        }
        
        tsp(node.right,root,total);
    }

    public static void main(String[] args) {
        int []inp = {1,2,3,4,5,6,7};
        Node root = construct(inp,0,inp.length-1);
        display(root);
    }
}
