public class Main {
    private class Node{
        int data;
        ArrayList<Node> children;
        Node(int val){
            data = val;
            children = new ArrayList<>();
        }
    }
    public static Node constructGT(Integer arr[]){
        
    }
    public static void main(String args[]){
        Integer arr[] = {10,20,null,30,50,null,60,null,null,40,null,null};
        Node root = constructGT(arr);
    }
}
