import java.util.*;
public class Introduction {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class ConstructPair{
        Node node;
        int state;
        ConstructPair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(Integer input[]){
        Stack<ConstructPair> st = new Stack<>();
        Node root = new Node(input[0],null,null);

        st.push(new ConstructPair(root, 1));
        int idx = 1;
        while(st.size() > 0){
            ConstructPair top = st.peek();

            if(top.state == 1){
                // left child
                Integer ele = input[idx]; // next element
                if(ele != null){
                    Node leftNode = new Node(ele);
                    top.node.left = leftNode;
                    st.push(new ConstructPair(leftNode, 1));
                }
                top.state++;
                idx++;
            }else if(top.state == 2){
                // right child
                Integer ele = input[idx]; // next element
                if(ele != null){
                    Node rightNode = new Node(ele);
                    top.node.right = rightNode;
                    st.push(new ConstructPair(rightNode, 1));
                }
                top.state++;
                idx++;
            }else {
                // if(top.state == 3) : left & right both have been processed
                st.pop();
            }
        }
        return root;
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
    
    public static int size(Node node) {
        if(node == null){
            return 0;
        }
        int size = 0;
        size += size(node.left); // count of nodes from left sub-tree
        size += size(node.right); // count of nodes from right sub-tree
        size += 1; // for myself
        
        return size;
    }

    public static int sum(Node node) {
        if(node == null){
            return 0;
        }
        int sum = 0;
        sum += sum(node.left); // sum of all nodes belonging to left subtree
        sum += sum(node.right); // sum of all nodes belonging to right subtree
        sum += node.data; // add myself
        
        return sum;
    }

    public static int max(Node node) {
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lmax = max(node.left);
        int rmax = max(node.right);
        int ans = Math.max(Math.max(lmax,rmax),node.data);
        
        return ans;
    }

    public static int height(Node node) {
        if(node == null){
            // return 0; // height in terms of number of nodes
            return -1; // height in terms of number of edges
        }
        int lht = height(node.left);
        int rht = height(node.right);
        int ht = Math.max(lht,rht)+1;
        
        return ht;
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        boolean resLeft = find(node.left, data);
        if (resLeft) {
            return true;
        }

        boolean resRight = find(node.right, data);
        if (resRight) {
            return true;
        }

        // implication : data not found
        return false;
    }

    public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
        if (node == null) {
            // invalid pos
            return new ArrayList < > ();
        }

        if (node.data == data) {
            // element found
            ArrayList < Integer > list = new ArrayList < > ();
            list.add(node.data);
            return list;
        }

        ArrayList < Integer > resLeft = nodeToRootPath(node.left, data);
        if (resLeft.size() > 0) {
            // element has been found
            resLeft.add(node.data);
            return resLeft;
        }

        ArrayList < Integer > resRight = nodeToRootPath(node.right, data);
        if (resRight.size() > 0) {
            // element has been found
            resRight.add(node.data);
            return resRight;
        }

        // implication : data not found
        return new ArrayList < > ();
    }

    public static void levelOrder(Node root) {
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> helperQ = new ArrayDeque<>();
        
        // initial step
        mainQ.add(root);
        
        while(mainQ.size() > 0){
            // remove
            Node tmp = mainQ.remove();
            
            // print
            System.out.print(tmp.data+" ");
            
            // add
            if(tmp.left != null){
                helperQ.add(tmp.left);
            }
            if(tmp.right != null){
                helperQ.add(tmp.right);
            }
            
            if(mainQ.size() == 0){
                System.out.println();
                
                // ref. swap
                Queue<Node> tempQ = mainQ;
                mainQ = helperQ;
                helperQ = tempQ;
            }
        }
    }

    public static void preTraversal(Node node){
        if(node == null){
            return;
        }
        // pre
        System.out.print(node.data+" ");
        preTraversal(node.left);
        preTraversal(node.right);
    }

    public static void postTraversal(Node node){
        if(node == null){
            return;
        }
        
        postTraversal(node.left);
        postTraversal(node.right);
        System.out.print(node.data+" ");
    }

    public static void inTraversal(Node node){
        if(node == null){
            return;
        }
        
        inTraversal(node.left);
        System.out.print(node.data+" ");
        inTraversal(node.right);
    }

    public static class ITPair{
        Node node;
        int state;

        ITPair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void iterativeTraversal(Node root){
        Stack<ITPair> st = new Stack<>();
        st.push(new ITPair(root, 1));
        String pre = "" , post = "" , in = "";

        while(st.size() > 0){
            ITPair top = st.peek();

            if(top.state == 1){
                // first visit
                pre += top.node.data+" "; // pre area
                top.state++;

                if(top.node.left != null){
                    st.push(new ITPair(top.node.left,1));
                }
            }else if(top.state == 2){
                // second visit
                in += top.node.data+" "; // in area
                top.state++;

                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 1));
                }
            }else {
                //if(top.state == 3) third visit
                post += top.node.data +" "; //  post area
                st.pop();
            }
        }

        System.out.println(pre+"\n"+in+"\n"+post);
    }

    public static void printKLevelsDown(Node node, int k) {
        if (node == null) {
            return;
        }

        if (k == 0) {
            // kth level
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }
    public static ArrayList < Node > nodeToRootPath1(Node node, int data) {
        if (node == null) {
            // invalid pos
            return new ArrayList < > ();
        }

        if (node.data == data) {
            // element found
            ArrayList < Node > list = new ArrayList < > ();
            list.add(node);
            return list;
        }

        ArrayList < Node > resLeft = nodeToRootPath1(node.left, data);
        if (resLeft.size() > 0) {
            // element has been found
            resLeft.add(node);
            return resLeft;
        }

        ArrayList < Node > resRight = nodeToRootPath1(node.right, data);
        if (resRight.size() > 0) {
            // element has been found
            resRight.add(node);
            return resRight;
        }

        // implication : data not found
        return new ArrayList < > ();
    }
   
    public static void printKNodesFar(Node root, int data, int totalDistance) {
        ArrayList < Node > path = nodeToRootPath1(root, data);

        for (int idx = 0; idx < path.size(); idx++) {
            int remainingDistance = totalDistance - idx;
            
            if (remainingDistance == 0) {
                System.out.println(path.get(idx).data);
                break;
            } else if (idx == 0) {
                printKLevelsDown(path.get(idx), remainingDistance);
            } else {
                Node curr = path.get(idx);
                Node prev = path.get(idx - 1);

                if (curr.left == prev) {
                    // there is no need to visit left branch
                    printKLevelsDown(curr.right,remainingDistance-1);
                } else {
                    // there is no need to visit right branch
                    printKLevelsDown(curr.left,remainingDistance-1);
                }
            }
        }
    }

    public static void pathToLeafFromRoot(Node node, String psf, int wsf, int lo, int hi) {
        if (node.left != null && node.right != null) {
            pathToLeafFromRoot(node.left, psf + node.data + " ", wsf + node.data, lo, hi);
            pathToLeafFromRoot(node.right, psf + node.data + " ", wsf + node.data, lo, hi);
        } else if (node.left != null) {
            pathToLeafFromRoot(node.left, psf + node.data + " ", wsf + node.data, lo, hi);
        } else if (node.right != null) {
            pathToLeafFromRoot(node.right, psf + node.data + " ", wsf + node.data, lo, hi);
        } else {
            // if(node.left == null && node.right == null) : leaf node
            psf += node.data;
            wsf += node.data;

            if (wsf >= lo && wsf <= hi) {
                // in range 
                System.out.println(psf);
            }
        }
    }

    public static Node createLeftCloneTree(Node node) {
        if(node == null){
            return null;
        }
        Node LCN = createLeftCloneTree(node.left);
        Node RCN = createLeftCloneTree(node.right);
        
        // tmp/clone
        Node clone = new Node(node.data,null,null);
        node.left = clone;
        clone.left = LCN;
        node.right = RCN;
        
        return node;
    }

    public static void printSingleChildNodes(Node node) {
        if(node == null){
            return;
        }
        
        if(node.left != null && node.right == null){
            // only left child exists
            System.out.println(node.left.data);
        }else if(node.left == null && node.right != null){
            // only right child exists
            System.out.println(node.right.data);
        }
        
        printSingleChildNodes(node.left);
        printSingleChildNodes(node.right);
    }

    public static void printSingleChildNodes(Node node,Node parent) {
        if(node == null){
            return;
        }
        
        if(parent != null){
            if(node == parent.left && parent.right == null){
                System.out.println(node.data);
            }else if(node == parent.right && parent.left == null){
                System.out.println(node.data);
            }
        }
        printSingleChildNodes(node.left,node);
        printSingleChildNodes(node.right,node);
    }

    static int tilt = 0;
    public static int tilt(Node node) {
        if(node == null){
            return 0;
        }
        
        int lSum = tilt(node.left);
        int rSum = tilt(node.right);
        int diff = Math.abs(lSum-rSum);
        tilt += diff;
        
        return lSum+rSum+node.data;
    }

    public static Node removeLeaves(Node node) {
        if(node == null){
            return null;
        }
        
        if(node.left == null && node.right == null){
            return null;
        }
        
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        
        return node;
    }

    static int overallDiameter = 0;
    public static int diameter1(Node node) {
        if(node == null){
            return -1;
        }
        int lht = diameter1(node.left);
        int rht = diameter1(node.right);
        int nDia = lht + rht + 2;
        if(nDia > overallDiameter){
            overallDiameter = nDia;
        }
        int nHt = Math.max(lht,rht)+1;
        return nHt;
    }
    public static class BSTPair{
        int max , min;
        boolean isBst;

        BSTPair(int max,int min,boolean isBst){
            this.max = max;
            this.min = min;
            this.isBst = isBst;
        }
    }
    public static BSTPair isBST(Node node){
        if(node == null){
            BSTPair bp = new BSTPair(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            return bp;
        }
        BSTPair  lp = isBST(node.left);
        BSTPair  rp = isBST(node.right);

        int myMax = Math.max(Math.max(lp.max, rp.max),node.data);
        int myMin = Math.min(Math.min(lp.min, rp.min),node.data);
        boolean isBst = lp.isBst && rp.isBst && node.data > lp.max && node.data < rp.min;

        return new BSTPair(myMax, myMin, isBst);
    }
    public static class IBPair{
        int ht;
        boolean isBalanced;
        IBPair(int ht,boolean isBalanced){
            this.ht = ht;
            this.isBalanced = isBalanced;
        }
    }
    public static IBPair isTreeBalanced(Node node){
        if(node == null){
            return new IBPair(-1, true);
        }
        IBPair lp = isTreeBalanced(node.left);
        IBPair rp = isTreeBalanced(node.right);

        int myht = Math.max(lp.ht,rp.ht)+1;
        int bf = Math.abs(lp.ht-rp.ht);
        boolean isBalanced = lp.isBalanced && rp.isBalanced && bf <= 1;
        
        return new IBPair(myht, isBalanced);
    }

    public static class LBSTPair{
        int max,min,size,lbstNode;
        boolean isBst;
    }
    public static LBSTPair largestBSTSubtree(Node node){
        if(node == null){
            LBSTPair bp = new LBSTPair();
            bp.max = Integer.MIN_VALUE;
            bp.min = Integer.MAX_VALUE;
            bp.size = 0;
            bp.isBst = true;
            return bp;
        }
        LBSTPair lp = largestBSTSubtree(node.left);
        LBSTPair rp = largestBSTSubtree(node.right);
        LBSTPair mp = new LBSTPair();
        
        mp.max = Math.max(node.data,Math.max(lp.max,rp.max));
        mp.min = Math.min(node.data,Math.min(lp.min,rp.min));
        mp.isBst = lp.isBst && rp.isBst && node.data > lp.max && node.data < rp.min;
       
        if(mp.isBst){
            mp.size = lp.size+rp.size+1;
            mp.lbstNode = node.data;
        }else{
            if(lp.size >= rp.size){
                mp.size = lp.size;
                mp.lbstNode = lp.lbstNode;
            }else{
                mp.size = rp.size;
                mp.lbstNode = rp.lbstNode;
            }
        }
        
        return mp;
    }
    public static void main(String[] args) {
        Integer input[] = {10 , 20 , 40 , null , null , 50 , 60 , null , null , 70 , null ,null, 30 , null , 80 , null , null};
        // System.out.println(input[3]);
        Node root = construct(input);

        // System.out.print("in:");
        // inTraversal(root);
        // System.out.println(".");

        // System.out.print("pre:");
        // preTraversal(root);
        // System.out.println(".");

        // System.out.print("post:");
        // postTraversal(root);
        // System.out.println(".");

        // iterativeTraversal(root);

        // BSTPair res = isBST(root);
        // System.out.println(res.isBst);

        // IBPair res = isTreeBalanced(root);
        // System.out.println(res.isBalanced);

        LBSTPair res = largestBSTSubtree(root);
        System.out.println(res.lbstNode+"@"+res.size);
    }
}
