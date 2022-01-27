import java.util.*;

public class L001 {
    public static class Node{
        int data;
        ArrayList<Node> children;

        Node(int data){
            this.data = data;
            children = new ArrayList<>();
        }
    }
    public static Node construct(int input[]){
        Node root = new Node(input[0]);

        Stack<Node> st = new Stack<>();
        st.push(root);

        for(int idx = 1; idx < input.length ; idx++){
            int val = input[idx];

            if(val == -1){
                st.pop();
            }else{
                Node newNode = new Node(val);
                st.peek().children.add(newNode);
                st.push(newNode);
            }
        }

        return root;
    }

    public static void display(Node node){
        // self printing 
         System.out.print(node.data + "->");
         for(Node child : node.children){
            System.out.print(child.data+" ");
         }
         System.out.println(".");

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

    public static int max(Node node){
        int ans = Integer.MIN_VALUE;
        for(Node child : node.children){
            int rres = max(child);

            if(rres > ans){
                ans = rres;
            }
        }
        if(node.data > ans){
            ans = node.data;
        }

        return ans;
    }

    public static void levelOrder(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.add(root);
        
        while(queue.size() > 0){
            // remove
            Node fNode = queue.remove();
            // print
            System.out.print(fNode.data+" ");
            // add
            for(Node child : fNode.children){
                queue.add(child);
            }
        }
        System.out.println(".");
    }

    public static void levelOrderLinewise(Node root){
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> helperQ = new ArrayDeque<>();
        
        mainQ.add(root);
        
        while(mainQ.size() > 0 ){
            Node fNode = mainQ.remove();
            
            System.out.print(fNode.data+" ");
            
            for(Node child : fNode.children){
                helperQ.add(child);
            }
            
            if(mainQ.size() == 0){
                System.out.println();
                
                Queue<Node> tmpQ = mainQ;
                mainQ = helperQ;
                helperQ = tmpQ;
            }
        }
      }

    public static void main(String[] args) {
        int input[] = {10,20,50,-1,60,-1,-1,30,90,-1,-1,40,70,-1,80,-1,-1,-1};
        Node root = construct(input);
        display(root);
    }
}
