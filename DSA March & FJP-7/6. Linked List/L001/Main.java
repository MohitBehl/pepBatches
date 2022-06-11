public class Main{
    private static class Node{
        int data;
        Node next;
        Node(){
            data = 0;
            next = null;
        }
        Node(int data){
            this.data = data;
        }
        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    
    private static class LinkedList{
        private Node head , tail;
        private int size;

        LinkedList(){
            head = tail = null;
            size = 0;
        }
    }
    
    public static void main(){
        LinkedList ll = new LinkedList();
    }
}