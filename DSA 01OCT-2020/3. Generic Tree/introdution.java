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

    public static Node getTail(Node node) {
        while (node.children.size() > 0) {
            node = node.children.get(0);
        }
        return node;
    }

    public static void linearize(Node node) {
        for (Node child: node.children) {
            linearize(child);
        }

        while (node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size() - 1);
            Node secondLastChild = node.children.get(node.children.size() - 1);

            Node tailNode = getTail(secondLastChild);

            tailNode.children.add(lastChild);
        }
    }

    public static boolean find(Node node, int ele) {
        if (node.data == ele) {
            return true;
        }

        for (Node child: node.children) {
            if (find(child, ele)) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList < Integer > nodeToRootPath(Node node, int ele) {
        if (node.data == ele) {
            ArrayList < Integer > list = new ArrayList < > ();
            list.add(ele);
            return list;
        }

        for (Node child: node.children) {
            ArrayList < Integer > ans = nodeToRootPath(child, ele);
            if (ans.size() > 0) {
                // element was found in the child-subtree & a proper ele to child node path is being returned
                ans.add(node.data);
                return ans;
            }
        }

        return new ArrayList < > ();
    }

    public static int lca(Node root, int d1, int d2) {
        ArrayList < Integer > pathD1 = nodeToRootPath(root, d1);
        ArrayList < Integer > pathD2 = nodeToRootPath(root, d2);

        int i = pathD1.size() - 1, j = pathD2.size() - 1;

        while (i >= 0 && j >= 0 && pathD1.get(i) == pathD2.get(j)) {
            i--;
            j--;
        }

        return pathD1.get(i + 1);
    }

    public static int distanceBetweenNodes(Node root, int d1, int d2) {
        ArrayList < Integer > pathD1 = nodeToRootPath(root, d1);
        ArrayList < Integer > pathD2 = nodeToRootPath(root, d2);

        int i = pathD1.size() - 1, j = pathD2.size() - 1;

        while (i >= 0 && j >= 0 && pathD1.get(i) == pathD2.get(j)) {
            i--;
            j--;
        }

        i++;
        j++;

        return i + j;
    }
    
    private static class Pair {
        int state;
        Node node;
    }

    public static void IterativePreandPostOrder(Node root) {
        String pre = "";
        String post = "";

        Stack < Pair > st = new Stack < > ();

        Pair rootPair = new Pair();
        rootPair.state = -1;
        rootPair.node = root;

        st.push(rootPair);
        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == -1) {
                // pre
                pre += top.node.data + " ";

                top.state++;
            } else if (top.state == top.node.children.size()) {
                // post
                post += top.node.data + " ";

                st.pop();
            } else {
                // top.state >= 0 && top.state < top.node.children.size()

                Pair childPair = new Pair();
                childPair.state = -1;
                childPair.node = top.node.children.get(top.state);

                top.state++;
                st.push(childPair);
            }
        }

        System.out.println(pre + "\n" + post);
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
