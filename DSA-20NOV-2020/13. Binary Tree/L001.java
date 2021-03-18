import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data , Node left , Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree{
    private Node root;

    private static class Pair{
        int state;
        Node node;

        Pair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }

    BinaryTree(Integer input[]){
        if(input.length == 0){
            root = null;
        }else{
            root = new Node(input[0],null,null);

            Stack<Pair> st = new Stack<Pair>();
            st.push(new Pair(root,1));
            int idx = 1;
            while(st.size() > 0){
                Pair top = st.peek();

                if(top.state == 1){
                    Integer val = input[idx++];
                    if(val != null){
                        Node newNode = new Node(val,null,null);
                        top.node.left = newNode;
                        st.push(new Pair(newNode,1));
                    }
                    top.state++;
                }else if(top.state == 2){
                    Integer val = input[idx++];
                    if(val != null){
                        Node newNode = new Node(val,null,null);
                        top.node.right = newNode;
                        st.push(new Pair(newNode,1));
                    }
                    top.state++;
                }else{
                    // top.state == 3
                    st.pop();
                }
            }
        }
    }

    public void display(){
        displayHelper(root);
    }

    private void displayHelper(Node node){
        if(node == null){
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data;
        str += " <- "+node.data+" -> ";
        str += node.right == null ? "." : node.right.data;

        System.out.println(str);

        displayHelper(node.left);
        displayHelper(node.right);
    }

    public int max(){
        return maxHelper(root);
    }
    private int maxHelper(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lmax = maxHelper(node.left);
        int rmax = maxHelper(node.right);

        return Math.max(lmax,Math.max(rmax,node.data));
    }

    public int height(){
        return heightHelper(root);
    }
    private int heightHelper(Node node){
        if(node == null){
            return -1;
        }
        int lht = heightHelper(node.left);
        int rht = heightHelper(node.right);

        return Math.max(lht,rht)+1;
    }

    public int size(){
        return sizeHelper(root);
    }
    private int sizeHelper(Node node){
        if(node == null){
            return 0;
        }
        int lsize = sizeHelper(node.left);
        int rsize = sizeHelper(node.right);
        return lsize+rsize+1;
    }

    public int sum(){
        return sumHelper(root);
    }
    private int sumHelper(Node node){
        if(node == null){
            return 0;
        }
        int lsum = sumHelper(node.left);
        int rsum = sumHelper(node.right);
        return lsum+rsum+node.data;
    }
}
public class L001 {   

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer arr[] = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            String inp = scn.next();
            
            if(inp.equals("n") == true){
                arr[i] = null;
            }else{
                arr[i] = Integer.parseInt(inp);
            }
        }

        BinaryTree bt = new BinaryTree(arr);

        int size = bt.size();
        int sum = bt.sum();
        int max = bt.max();
        int ht = bt.height();
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }
}
