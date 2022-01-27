import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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

    public static void mirror(Node node){
    
        for(Node child : node.children){
            mirror(child);
        }
        
        Collections.reverse(node.children);
    }


    public static void removeLeaves(Node node) {
      
        for(int idx = node.children.size()-1 ; idx >= 0 ; idx--){
            Node child = node.children.get(idx);
            if(child.children.size() == 0){
                // leaf node
                node.children.remove(idx);
            }
        }
        
        for(Node child : node.children){
            removeLeaves(child);
        }
        
    }


    public static Node getTail(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        
        return node;
    }
  
    public static void linearize(Node node){
      for(Node child : node.children){
          linearize(child);
      }
      
      while(node.children.size() > 1){
          Node lc = node.children.remove(node.children.size()-1);
          Node slc = node.children.get(node.children.size()-1);
          
          Node tail = getTail(slc);
          
          tail.children.add(lc);
      }
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }
        
        for(Node child : node.children){
            ArrayList<Integer> res = nodeToRootPath(child,data);
            
            if(res.size() != 0){
                res.add(node.data);
                return res;
            }
        }
        
        return new ArrayList<>();
     }

    public static boolean find(Node node, int data) {
        if(node.data == data){
            return true;
        }
        
        for(Node child : node.children){
            boolean res = find(child,data);
            if(res){
                return true;
            }
        }
        
        return false;
    }


    public static boolean areSimilar(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        
        for(int i = 0 ; i < n1.children.size() ; i++){
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(i);
            
            boolean res = areSimilar(child1,child2);
            
            if(res == false){
                return false;    
            }
        }
        
        return true;
    }

    public static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        
        for(int i = 0 ; i < n1.children.size() ; i++){
            Node c1 = n1.children.get(i);
            int mIdx = n2.children.size()-1-i;
            Node c2 = n2.children.get(mIdx);
            
            boolean res = areMirror(c1,c2);
            if(res == false){
                return false;
            }
        }
        
        return true;
    }

    public static boolean IsSymmetric(Node node) {
        return areMirror(node,node);
    }

    static int size , sum , max , min;
    public static void multiSolver(Node node){
        size++;
        sum += node.data;
        max = Math.max(max,node.data);
        min = Math.min(min,node.data);

        for(Node child : node.children){
            multiSolver(child);
        }
    }

    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccessor(Node node, int data) {
        if(state == 0){
            if(node.data == data){
                state++;
            }else{
                predecessor = node;
            }
        }else if(state == 1){
            successor = node;
            state++;
        }
        
        for(Node child : node.children){
            predecessorAndSuccessor(child,data);
        }
    }
    public static void main(String[] args) {
        int input[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(input);

        // display(root);

        // System.out.println(size(root));
        // levelOrder(root);

        // levelOrderLinewise(root);

        // size = 0;
        // sum = 0;
        // max = Integer.MIN_VALUE;
        // min = Integer.MAX_VALUE;
        // multiSolver(root);
        // System.out.println("Size : "+size);
        // System.out.println("sum : "+sum);
        // System.out.println("max : "+max);
        // System.out.println("min : "+min);
        
        int data = 120;
        predecessor = null;
        successor = null;
        state = 0;
        predecessorAndSuccessor(root, data);
        if(predecessor == null){
        System.out.println("Predecessor = Not found");
        } else {
        System.out.println("Predecessor = " + predecessor.data);
        }

        if(successor == null){
        System.out.println("Successor = Not found");
        } else {
        System.out.println("Successor = " + successor.data);
        }
    }
}