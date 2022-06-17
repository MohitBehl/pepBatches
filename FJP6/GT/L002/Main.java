import java.util.*;
public class Main{
    static class Node{
        int data;
        ArrayList<Node> children;

        Node(int data){
            this.data = data;
            children = new ArrayList<>();
        }
    }
    public static Node construct(Integer []arr){
        Stack<Node> st = new Stack<>();

        Node root = new Node(arr[0]);
        st.push(root);

        int idx = 1;
        while(idx < arr.length){
            Integer val = arr[idx];

            if(val == null){
                st.pop();
            }else{
                Node node = new Node(val);
                Node par = st.peek();
                par.children.add(node);
                st.push(node);
            }
            idx++;
        }
        return root;
    }
    
    public static void display(Node node){
        System.out.print(node.data+" -> ");
        for(Node child : node.children){
            System.out.print(child.data+" ");
        }
        System.out.println(".");

        for(Node child : node.children){
            display(child);
        }
    }
    public static void traversals(Node node){
        System.out.println("Node Pre "+node.data);

        for(Node child : node.children){
        System.out.println("Edge Pre "+node.data+"--"+child.data);
        traversals(child);
        System.out.println("Edge Post "+node.data+"--"+child.data);
        }

        System.out.println("Node Post "+node.data);
    }

    public static void levelOrder(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size() > 0){
            Node rem = queue.remove();
            System.out.print(rem.data+" ");
            for(Node child : rem.children){
                queue.add(child);
            }
        }
        System.out.println(".");
    }

    public static void levelOrderLinewise(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> hq = new ArrayDeque<>();
        mq.add(node);

        while(mq.size() > 0){
            Node rem = mq.remove();
            System.out.print(rem.data+" ");

            for(Node child : rem.children){
                hq.add(child);
            }

            if(mq.size() == 0){
                System.out.println();
                Queue<Node> tq = mq;
                mq = hq;
                hq = tq;
            }
        }
    }
    public static boolean find(Node node, int data) {
        if(node.data == data){
        return true;
        }

        for(Node child : node.children){
        boolean rrec = find(child,data);
        if(rrec){
            return true;
        }
        }

        return false;
    }
    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
        ArrayList<Integer> base = new ArrayList<>();
        base.add(data);
        return base;
        }

        for(Node child : node.children){
        ArrayList<Integer> rres = nodeToRootPath(child,data);
        if(rres.size() > 0){
            rres.add(node.data);
            return rres;
        }
        }
        return new ArrayList<>();
    }
    public static void main(String args[]){
        Integer []arr = {10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null, null, 40, 80, null, null, null};
        Node root = construct(arr);
        display(root);
        int treeSize = size(root);
        System.out.println(treeSize);
    }
}