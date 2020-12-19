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

    // replace with some of larger
    static int sum = 0;
    public static void rwsol(Node node) {
        if (node == null) {
            return;
        }
        
        rwsol(node.right);

        int tmp = node.data;

        node.data = sum;
        sum = sum + tmp;

        rwsol(node.left);
    }

    // print in range
    public static void pir(Node node, int d1, int d2) {
        if(node == null){
            return;
        }
        
        if(d1 < node.data && d2 < node.data){
            pir(node.left,d1,d2);
        }else if(d1 > node.data && d2 > node.data){
            pir(node.right,d1,d2);
        }else{
            pir(node.left,d1,node.data);
            System.out.println(node.data);
            pir(node.right,node.data,d2);
        }
      }

    public static void targetSumPair2(Node root,Node node,int target){
        if(node == null){
            return;
        }
        
        targetSumPair2(root,node.left,target);
        
        int val = node.data;
        int cval = target - val;
        if(cval > val){
            if(find(root,cval)){
                System.out.println(val+" "+cval);
            }
        }else{
            return;
        }
        
        targetSumPair2(root,node.right,target);
    }

    public static void targetSumPair1Helper(Node node,ArrayList<Integer> list){
        if(node == null){
            return;
        }
        
        targetSumPair1Helper(node.left,list);
        list.add(node.data);
        targetSumPair1Helper(node.right,list);
    }
    public static void targetSumPair1(Node root ,int target){
        ArrayList<Integer> list = new ArrayList<Integer>();
        targetSumPair1Helper(root,list);
        
        // System.out.println(list);
        
        int lo = 0, hi = list.size()-1;
        
        while(lo < hi){
            int lv = list.get(lo);
            int rv = list.get(hi);
            
            if(lv + rv < target){
                lo++;
            }else if(lv + rv > target){
                hi--;
            }else{
                // lv + rv == target
                System.out.println(lv+" "+rv);
                lo++;
                hi--;
            }
        }
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