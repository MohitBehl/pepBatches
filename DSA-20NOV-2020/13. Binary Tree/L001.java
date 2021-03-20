import java.util.*;

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

    public void traversals(){
        System.out.print("PreOrder : ");
        preOrder(root);
        System.out.println(".");

        System.out.print("PostOrder : ");
        postOrder(root);
        System.out.println(".");

        System.out.print("InOrder : ");
        inOrder(root);
        System.out.println(".");
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        // pre-area
        System.out.print(node.data+" -> ");

        preOrder(node.left);
        preOrder(node.right);
    } 
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);

        // post-area
        System.out.print(node.data+" -> ");
    } 
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        // in-area
        System.out.print(node.data+" -> ");
        inOrder(node.right);
    } 

    public void levelOrder(){
        levelOrderHelper(root);
    }

    private void levelOrderHelper(Node node){
        // HW question snippet
    }

    public boolean find(int ele){
        return findHelper(root, ele);
    }
    private boolean findHelper(Node node,int ele){
        if(node == null){
            return false;
        }
        if(node.data == ele){
            return true;
        }
        boolean lRes = findHelper(node.left, ele);
        if(lRes){
            return true;
        }
        boolean rRes = findHelper(node.right, ele);
        if(rRes){
            return true;
        }
        return false;
    }

    public ArrayList<Integer> nodeToRootPath(int ele){
        return nodeToRootPathHelper(root, ele);
    }
    private ArrayList<Integer> nodeToRootPathHelper(Node node ,int ele){
        if(node == null){
            return new ArrayList<>();
        }

        if(node.data == ele){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        ArrayList<Integer> lPath = nodeToRootPathHelper(node.left, ele);
        if(lPath.size() != 0){
            lPath.add(node.data);
            return lPath;
        }

        ArrayList<Integer> rPath = nodeToRootPathHelper(node.right, ele);
        if(rPath.size() != 0){
            rPath.add(node.data);
            return rPath;
        }

        return new ArrayList<>();
    }

    public void printKLevelsDown(int k){
        printKLevelsDownHelper(root, k);
    }

    private void printKLevelsDownHelper(Node node,int k){
        if(node == null){
            return;
        }
        if(k == 0){
            System.out.println(node.data);
            return;
        }

        printKLevelsDownHelper(node.left, k-1);
        printKLevelsDownHelper(node.right, k-1);
    }

    public void kDistAway(int data,int totalDist){
        ArrayList<Node> list = nodeToRootPath(this.root, data);

        printKLevelsDownHelper(list.get(0), totalDist);
        for(int idx = 1 ; idx < list.size() ; idx++){
            int remDist = totalDist-idx;
            Node curr = list.get(idx);
            Node prev = list.get(idx-1);
            if(remDist == 0){
                System.out.println(curr.data);
                return;
            }else{
                if(curr.left == prev){
                    printKLevelsDownHelper(curr.right, remDist-1);
                }else{
                    printKLevelsDownHelper(curr.left, remDist-1);
                }
            }
        }
    }
    private ArrayList<Node> nodeToRootPath(Node node ,int ele){
        if(node == null){
            return new ArrayList<>();
        }

        if(node.data == ele){
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        ArrayList<Node> lPath = nodeToRootPath(node.left, ele);
        if(lPath.size() != 0){
            lPath.add(node);
            return lPath;
        }

        ArrayList<Node> rPath = nodeToRootPath(node.right, ele);
        if(rPath.size() != 0){
            rPath.add(node);
            return rPath;
        }

        return new ArrayList<>();
    }
}


public class L001 {   // rename this class to Main , inorder to submit this question

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
        // int level = scn.nextInt();
        BinaryTree bt = new BinaryTree(arr);

        // int size = bt.size();
        // int sum = bt.sum();
        // int max = bt.max();
        // int ht = bt.height();
        // System.out.println(size);
        // System.out.println(sum);
        // System.out.println(max);
        // System.out.println(ht);

        // bt.traversals();
        // bt.levelOrder();

        // bt.printKLevelsDown(level);
        
        int data = scn.nextInt();
        int k = scn.nextInt();

        bt.kDistAway(data, k);
    }
}
