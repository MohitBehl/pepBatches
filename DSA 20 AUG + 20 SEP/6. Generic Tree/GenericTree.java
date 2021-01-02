import java.util.*;
public class GenericTree {

    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccessor(Node node, int data) {
        if(state == 0){
            if(node.data == data){
                state = 1;
            }else{
                predecessor = node;
            }
        }else if(state == 1){
            successor = node;
            state = 2;
        }

        for(Node child : node.children){
            predecessorAndSuccessor(child, data);
        }
    }

    private static class MSNode{
        int sum , max , min , ht , size;
        MSNode(){
            // sum --> 0 , max --> Integer.MIN_VALUE , min --> Integer.MAX_VALUE ,  ht -->  -1 , size --> 0
            this(0,Integer.MIN_VALUE,Integer.MAX_VALUE,-1,0);
        }
        MSNode(int sum,int max,int min,int ht,int size){
            this.sum = sum;
            this.ht = ht;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    public static MSNode multiSolver(Node node){
        int sum = 0 , max = Integer.MIN_VALUE,min = Integer.MAX_VALUE,size = 0 , ht = -1;
        for(Node child:node.children){
            MSNode rres = multiSolver(child);

            sum += rres.sum;
            max = Math.max(max,rres.max);
            min = Math.min(min,rres.min);
            size += rres.size;
            ht = Math.max(ht,rres.ht);
        }
        sum += node.data;
        max = Math.max(max, node.data);
        min = Math.min(min, node.data);
        ht += 1;
        size += 1;

        return new MSNode(sum,max,min,ht,size);
    }
    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }

        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }

        for (Node child: node.children) {
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k) {
        int data = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        for(int i = 1 ; i <= k ; i++){
            ceilAndFloor(node, data);

            data = floor;
            floor = Integer.MIN_VALUE;
        }

        return data;
    }


    public static void linearize(Node node) {
        for (Node child: node.children) {
            linearize(child);
        }

        while (node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size() - 1);
            Node secondLastChild = node.children.get(node.children.size() - 1);

            Node tail = getTail(secondLastChild);

            tail.children.add(lastChild);
        }
    }
    

    public static Node getTail(Node node) {
        while (node.children.size() != 0) {
            node = node.children.get(0);
        }

        return node;
    }

    public static Node linearizeEfficient(Node node) {
        if(node.children.size() == 0){
            return node;
        }
        Node tail = linearizeEfficient(node.children.get(node.children.size()-1));
        while(node.children.size() > 1){
            Node last = node.children.remove(node.children.size()-1);
            Node slNode = node.children.get(node.children.size()-1);
            Node slTail = linearizeEfficient(slNode);
            slTail.children.add(last);
        }
        
        return tail;
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        Node root = construct(arr);
        // predecessor = null;
        // successor = null;
        // state = 0;
        // predecessorAndSuccessor(root, data);
        // if (predecessor == null) {
        //     System.out.println("Predecessor = Not found");
        // } else {
        //     System.out.println("Predecessor = " + predecessor.data);
        // }

        // if (successor == null) {
        //     System.out.println("Successor = Not found");
        // } else {
        //     System.out.println("Successor = " + successor.data);
        // }

        MSNode msnode = multiSolver(root);
        System.out.println("sum : "+msnode.sum);
        System.out.println("max : "+msnode.max);
        System.out.println("min : "+msnode.min);
        System.out.println("ht : "+msnode.ht);
        System.out.println("size : "+msnode.size);
    }

}

