import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  // preorder traversal recursive
  public static void preTraversal(Node node) {
    if (node == null) {
        return;
    }
    // pre area
    System.out.print(node.data+" -> ");

    preTraversal(node.left);
    preTraversal(node.right);
}
// inorder traversal recursive
public static void inTraversal(Node node) {
    if (node == null) {
        return;
    }

    inTraversal(node.left);

    // in area
    System.out.print(node.data+" -> ");

    inTraversal(node.right);
}

// postorder traversal recursive
public static void postTraversal(Node node) {
    if (node == null) {
        return;
    }
    postTraversal(node.left);

    postTraversal(node.right);

    // post area
    System.out.print(node.data+" -> ");
}

  public static class TraversalPair{
      Node node;
      int state;
      
      TraversalPair(Node n,int s){
          node = n;
          state = s;
      }
  }
  public static void iterativePrePostInTraversal(Node root) {
    Stack<TraversalPair> st = new Stack<TraversalPair>();
    
    st.push(new TraversalPair(root,1));
    String pre = "" , post = "", in = "";
    while(st.size() > 0){
        TraversalPair topPair = st.peek();
        
        if(topPair.state == 1){
            // preorder area
            pre += topPair.node.data+" ";
            topPair.state++;
            
            if(topPair.node.left != null){
                st.push(new TraversalPair(topPair.node.left,1));
            }
        }else if(topPair.state == 2){
            // inorder area
            in += topPair.node.data+" ";
            topPair.state++;
            
            if(topPair.node.right != null){
                st.push(new TraversalPair(topPair.node.right,1));
            }
        }else if(topPair.state == 3){
            //postorder area
            post += topPair.node.data+" ";
            st.pop();
        }
    }    
    System.out.println(pre+"\n"+in+"\n"+post);
  }

  public static boolean find(Node node, int data) {
    if (node == null) {
        return false;
    }

    if (node.data == data) {
        return true;
    }

    boolean findL = find(node.left, data);
    if (findL) {
        return true;
    }
    
    boolean findR = find(node.right, data);
    if (findR) {
        return true;
    }

    return false;
}

public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
    if (node == null) {
        return new ArrayList<Integer>();
    }

    if (node.data == data) {
        ArrayList<Integer> base = new ArrayList<Integer>();
        base.add(node.data);
        return base;
    }

    ArrayList<Integer> lPath = nodeToRootPath(node.left,data);
    if (lPath.size() > 0) {
        // element has been discovered
        lPath.add(node.data);
        return lPath;
    }
    
    ArrayList<Integer> rPath = nodeToRootPath(node.right,data);
    if (rPath.size() > 0) {
        // element has been discovered
        rPath.add(node.data);
        return rPath;
    }

    return new ArrayList<Integer>();
}

public static void printKLevelsDown(Node node, int k){
    if(node == null){
        return;
    }
    if(k == 0){
        // no further movement required
        System.out.println(node.data);
        return;
    }
    
    printKLevelsDown(node.left,k-1);
    printKLevelsDown(node.right,k-1);
}

public static void pathToLeafFromRoot(Node node, String psf, int ssf, int lo, int hi){
    if(node == null){
        return;
    }
    if(node.left == null && node.right == null){
        // 1. leaf node 
        int sum = ssf + node.data;
        String path = psf + node.data;
        
        // 2. sum in range
        if(sum >= lo && sum <= hi){
            System.out.println(path);
        }
        
        return;
    }
    
    pathToLeafFromRoot(node.left,psf+node.data+" ",ssf+node.data,lo,hi);
    pathToLeafFromRoot(node.right,psf+node.data+" ",ssf+node.data,lo,hi);
  }

  public static void printSingleChildNodes(Node node, Node parent){
    if(node == null){
        return;
    }
    if(parent != null){
        
        // node belongs to left
        if(parent.left != null && parent.left == node){
            // node is left child of parent --> to check right sibling exists  
            if(parent.right == null){
                // node is single child 
                System.out.println(node.data);
            }
        }else if(parent.right != null && parent.right == node){
        // node belongs to right
            //node is right child of it's parent --> to check for left sibling
            if(parent.left == null){
                // node is single child
                System.out.println(node.data);
            }
        }
    }
    printSingleChildNodes(node.left,node);
    printSingleChildNodes(node.right,node);
  }
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    iterativePrePostInTraversal(root);


    boolean found = find(root, data);
    System.out.println(found);

    ArrayList < Integer > path = nodeToRootPath(root, data);
    System.out.println(path);
  }

}