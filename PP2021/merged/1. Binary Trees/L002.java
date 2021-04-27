public class L002 {
    public static Node removeLeaves(Node node){
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

    public static void printSingleChildNodes(Node node){
        if(node == null){
            return;
        }
        
        if(node.right == null && node.left != null){
            System.out.println(node.left.data);
        }else if(node.right != null && node.left == null){
            System.out.println(node.right.data);
        }
        
        printSingleChildNodes(node.left);
        printSingleChildNodes(node.right);
    }
    static int tiltOfTree = 0;
    public static int tilt(Node node){
    if(node == null){
        return 0;
    }

    int lSum = tilt(node.left);
    int rSum = tilt(node.right);

    int tiltOfNode = Math.abs(lSum-rSum);
    tiltOfTree += tiltOfNode;

    return lSum+rSum+node.data;
    }
    public static class TiltSolver{
        int tiltOfTree;
        int sum;
        TiltSolver(int tiltOfTree , int sum){
            this.tiltOfTree = tiltOfTree;
            this.sum = sum;
        }
    }
    public static TiltSolver tilt1(Node node){
        if(node == null){
            return new TiltSolver(0,0);
        }
        TiltSolver lres = tilt1(node.left);
        TiltSolver rres = tilt1(node.right);
        
        int mySum = lres.sum+rres.sum+node.data;
        int tiltOfTree = lres.tiltOfTree+rres.tiltOfTree+Math.abs(lres.sum-rres.sum);
        
        return new TiltSolver(tiltOfTree,mySum);
    }

    public static class IsBSTSolver{
        int max,min,lBstSize;
        boolean isbst;
        Node lBstNode;
        
        IsBSTSolver(int min,int max,boolean isbst,int lBstSize,Node lBstNode){
            this.min = min;
            this.max = max;
            this.isbst = isbst;
            this.lBstSize = lBstSize;
            this.lBstNode = lBstNode;
        }
    }
    
    public static IsBSTSolver checkBst(Node node){ // largest bst node
        if(node == null){
            return new IsBSTSolver(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0,null);
        }
        IsBSTSolver lres = checkBst(node.left);
        IsBSTSolver rres = checkBst(node.right);
        
        int min = Math.min(node.data,Math.min(lres.min,rres.min));
        int max = Math.max(node.data,Math.max(lres.max,rres.max));
        boolean isbst = lres.isbst && rres.isbst && node.data > lres.max && node.data < rres.min;
        Node lBstNode;
        int lBstSize;
        if(isbst){
            lBstNode = node;
            lBstSize = lres.lBstSize + rres.lBstSize + 1;
        }else{
            if(lres.lBstSize >= rres.lBstSize){
                lBstNode = lres.lBstNode;
                lBstSize = lres.lBstSize;
            }else{
                lBstNode = rres.lBstNode;
                lBstSize = rres.lBstSize;
            }
        }
        return new IsBSTSolver(min,max,isbst,lBstSize,lBstNode);
    }
    public static class IsBSTSolver{
        int max,min;
        boolean isbst;
        
        IsBSTSolver(int min,int max,boolean isbst){
            this.min = min;
            this.max = max;
            this.isbst = isbst;
        }
    }
    
    public static IsBSTSolver checkBst(Node node){
        if(node == null){
            return new IsBSTSolver(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        }
        IsBSTSolver lres = checkBst(node.left);
        IsBSTSolver rres = checkBst(node.right);
        
        int min = Math.min(node.data,Math.min(lres.min,rres.min));
        int max = Math.max(node.data,Math.max(lres.max,rres.max));
        boolean isbst = lres.isbst && rres.isbst && node.data > lres.max && node.data < rres.min;
        return new IsBSTSolver(min,max,isbst);
    }
    static int diaOfTree;
    public static int diameter1(Node node) {
    if(node == null){
        return -1;
    }
    int leftHt = diameter1(node.left);
    int rightHt = diameter1(node.right);
    
    int diaOfNode = leftHt + rightHt + 2;
    if(diaOfNode > diaOfTree){
        diaOfTree = diaOfNode;
    }
    
    return Math.max(leftHt,rightHt)+1;
    }
    public static class DiaSolver{
        int ht;
        int diaOfTree;
        DiaSolver(int ht,int diaOfTree){
            this.ht = ht;
            this.diaOfTree = diaOfTree;
        }
    }
    
    public static DiaSolver diameter2(Node node){
        if(node == null){
            return new DiaSolver(-1,0);
        }
        DiaSolver lres = diameter2(node.left);
        DiaSolver rres = diameter2(node.right);
        
        int ht  = Math.max(lres.ht,rres.ht)+1;
        int diaOfNode = lres.ht+rres.ht+2;
        int diaOfTree = Math.max(diaOfNode,Math.max(lres.diaOfTree,rres.diaOfTree));
        
        return new DiaSolver(ht,diaOfTree);
    }

    public static Node createLeftCloneTree(Node node){
        if(node == null){
            return null;
        }
        Node lres = createLeftCloneTree(node.left);
        Node rres = createLeftCloneTree(node.right);
        
        Node clone = new Node(node.data,null,null);
        clone.left = lres;
        node.left = clone;
        
        return node;
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
        System.out.println(tilt1(root).tiltOfTree);
        // tilt(root);
        // System.out.println(tiltOfTree);

        
        // IsBSTSolver res = checkBst(root);
        // System.out.println(res.lBstNode.data+"@"+res.lBstSize);

        // IsBSTSolver res = checkBst(root);
        // System.out.println(res.isbst);

        // diaOfTree = 0;
        // diameter1(root);
        // System.out.println(diaOfTree);
        DiaSolver res = diameter2(root);
        System.out.println(res.diaOfTree);
      }

}
