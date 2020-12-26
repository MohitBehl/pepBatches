public class Inroduction {
    public static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static Node construct(int input[]) {
        Stack < Node > st = new Stack < > ();
        Node root = new Node();
        root.data = input[0];

        st.push(root);

        for (int i = 1; i < input.length; i++) {
            if (input[i] == -1) {
                st.pop();
            } else {
                Node node = new Node(); // creation
                node.data = input[i]; // val set

                st.peek().children.add(node); // node <-- parent

                st.push(node);
            }
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

    public static int size(Node node) {
        int res = 0;
        for (Node child: node.children) {
            res += size(child); // faith
        }
        res += 1; // mywork

        return res;
    }

    public static int max(Node node) {
        int res = Integer.MIN_VALUE;
        for (Node child: node.children) {
            res = Math.max(res, max(child));
        }

        res = Math.max(res, node.data);

        return res;
    }
    
    public static int height(Node node) {
        int ht = -1;
        for (Node child: node.children) {
            ht = Math.max(ht, height(child));
        }

        ht += 1;

        return ht;
    }
    
    public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);

        for (Node child: node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }

    public static void main(String[] args) {

        int input[] = {
            10,
            20,
            50,
            -1,
            60,
            -1,
            -1,
            30,
            -1,
            40,
            -1,
            -1
        };
        Node root = construct(input);
        display(root);
    }
}
