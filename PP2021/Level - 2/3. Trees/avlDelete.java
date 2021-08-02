class avlDelete
{
    public static Node deleteNode(Node node, int data)
    {   
        if(node == null){
            return null;
        }

        if(data < node.data){
            node.left = deleteNode(node.left,data);
        }else if(data > node.data){
            node.right = deleteNode(node.right, data);
        }else{
            if(node.left == null && node.right == null){ // leaf node removal
                return null;
            }else if(node.left == null){ // single child removal ,  right child 
                return node.right;
            }else if(node.right == null){ // single child removal ,  left child
                return node.left;
            }else{ // both child exists
                int max = getMax(node.left);
                node.data = max;

                node.left = deleteNode(node.left, max);
                int lht = height(node.left) , rht = height(node.right);
                node.height = Math.max(lht, rht)+1;
                return node;
            }
        }

        int lht = height(node.left) , rht = height(node.right);
        node.height = Math.max(lht, rht)+1;
        int diff = lht - rht;

        Node newRoot = node;
        if(diff > 1){ // left
            if(data < node.left.data){ // LL
                newRoot = rightRotate(node);
            }else if(data > node.left.data){ // LR
                node.left = leftRotate(node.left);
                newRoot = rightRotate(node);
            }
        }else if(diff < -1){ // right
            if(data < node.right.data){ // RL
                node.right = rightRotate(node.right);
                newRoot = leftRotate(node);
            }else if(data > node.right.data){ // RR
               newRoot = leftRotate(node);
            }
        }
        return newRoot;
    }
    public static int getMax(Node node){
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }
    
    public static int height(Node node){
        if(node == null){
            return 0;
        }else{
            return node.height;
        }
    }

    public static Node leftRotate(Node a){
        Node b = a.right;
        Node t2 = b == null ? null : b.left;
        if(b != null){
            b.left = a;
        }
        a.right = t2;

        a.height = Math.max(height(a.left), height(a.right))+1;
        if(b != null){
            b.height = Math.max(height(b.left), height(b.right))+1;
        }
        return b;
    }

    public static Node rightRotate(Node a){
        Node b = a.left;
        Node t2 = b == null ? null : b.right;
        
        if(b != null){
            b.right = a;
        }
        a.left = t2;

        a.height = Math.max(height(a.left), height(a.right))+1;
        if(b != null){
            b.height = Math.max(height(b.left), height(b.right))+1;
        }
        return b;
    }
}