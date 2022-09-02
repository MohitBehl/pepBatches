public class Main{
    public List<Integer> preorderTraversal(TreeNode root) { // morris traversal
        List<Integer> ans = new ArrayList<>();
        
        while(root != null){
            if(root.left == null){ // root can be visited only once
                ans.add(root.val);
                root = root.right;
            }else{ //root -> first vis or second vis
                TreeNode rootp1 = root.left;
                while(rootp1.right != null && rootp1.right != root){
                    rootp1 = rootp1.right;
                }
                
                if(rootp1.right == null){ // first vis
                    ans.add(root.val);
                    rootp1.right = root; // connect
                    root = root.left;
                }else if(rootp1.right == root){ // second vis
                    rootp1.right = null; // disconnect
                    root = root.right;
                }
            }
        }
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
        
        while(root != null){
            if(root.left == null){ // root can be visited only once
                ans.add(root.val);
                root = root.right;
            }else{ //root -> first vis or second vis
                TreeNode rootp1 = root.left;
                while(rootp1.right != null && rootp1.right != root){
                    rootp1 = rootp1.right;
                }
                
                if(rootp1.right == null){ // first vis
                    rootp1.right = root; // connect
                    root = root.left;
                }else if(rootp1.right == root){ // second vis
                    ans.add(root.val);
                    rootp1.right = null; // disconnect
                    root = root.right;
                }
            }
        }
        return ans;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        // System.out.println(sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode root,StringBuilder sb){ // preorder
        if(root == null){
            sb.append("null ");
            return;
        }
        sb.append(root.val+" ");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(" ");
        // System.out.println(Arrays.toString(input));
        Codec.idx = 0;
        return deserializeHelper(input);
    }
    static int idx = 0;
    private TreeNode deserializeHelper(String input[]){
        if(idx == input.length){
            return null;
        }
        if(input[idx].equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(input[idx]));
        idx++;
        node.left = deserializeHelper(input);
        idx++;
        node.right = deserializeHelper(input);
        
        return node;
    }
}