public class Main{
    public static class Node{
        int data;
        Node left , right;
        Node(int val){
            this.data = val;
            left = right = null;
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node){
            this.node = node;
            this.state = 0;
        }
    }
    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root));

        while(st.size() > 0){
            // logic
        }
        return root;
    }
    public static void main(String args[]){

    }
}