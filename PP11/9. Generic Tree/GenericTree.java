import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenericTree{
    public static class Node{
        int data;
        ArrayList<Node> children;
    
        Node(){
            children = new ArrayList<>();
        }
        Node(int val){
            data = val;
            children = new ArrayList<>();
        }
    }

    public static Node construct(int input[]){
        Node root = new Node(input[0]);

        Stack<Node> st = new Stack<>();
        st.push(root);

        for(int i = 1 ; i < input.length ; i++){
            if(input[i] == -1){
                st.pop();
            }else{
                Node newNode = new Node(input[i]);
                st.peek().children.add(newNode);
                st.push(newNode);
            }
        }

        return root;
    }

    public static void display(Node node){
        System.out.print(node.data +" -> " );
        for(Node child : node.children){
            System.out.print(child.data+" ");
        }
        System.out.println();

        for(Node child : node.children){
            display(child);
        }
    }

    public static int size(Node node){
        int res = 0;
        for(Node child : node.children){
            res += size(child);
        }

        res += 1;

        return res;
    }

    public static int max(Node node) {
        int myMax = Integer.MIN_VALUE;

        for(Node child : node.children){
            myMax = Math.max(myMax,max(child));
        }

        myMax = Math.max(myMax, node.data);

        return myMax;
    }

    public static int height(Node node) {
        // int ht = 0; // on the basis of nodes
        int ht = -1; // on the basis of edges
        
        for(Node child : node.children){
            ht = Math.max(ht,height(child));
        }
        
        return ht+1;
    }

    public static void traversals(Node node){
        // pre-area
        System.out.println("Node Pre "+node.data);
        
        for(Node child : node.children){
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            traversals(child);
            System.out.println("Edge Post "+node.data+"--"+child.data);
        }
        
        // post-area
        System.out.println("Node Post "+node.data);
        
    }

    public static void levelOrder(Node root){
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while(queue.size() > 0){
            Node fnode = queue.remove();//remove
            System.out.print(fnode.data+" ");// print

            // add children to queue
            for(Node child : fnode.children){
                queue.add(child);
            }
        }
        System.out.println(".");
    }

    public static void levelOrderLinewise(Node root){
        Queue<Node> mainq = new ArrayDeque<>();
        Queue<Node> helperq = new ArrayDeque<>();

        mainq.add(root);

        while(mainq.size() > 0){
            Node fnode = mainq.remove();//remove
            System.out.print(fnode.data+" "); // print

            // add children to helperq
            for(Node child : fnode.children){
                helperq.add(child);
            }

            if(mainq.size() == 0){
                System.out.println();

                Queue<Node> tempq = mainq;
                mainq = helperq;
                helperq = tempq;
            }
        }
    }
    public static void main(String[] args) {
        int input[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(input);

        // display(root);

        // System.out.println(size(root));
        // levelOrder(root);

        levelOrderLinewise(root);
    }
}