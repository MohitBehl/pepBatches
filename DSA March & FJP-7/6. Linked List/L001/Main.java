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
            this.next = null;
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

        public void addFirst(int val) {
            Node node = new Node(val);
            if(this.size == 0){
                this.head = this.tail = node;
            }else{
                node.next = this.head;
                this.head = node;
            }
            this.size++;
        }

        public int size(){
            return this.size;
        }

        public void display(){
            if(this.size == 0) 
                return;

            Node curr = this.head;

            while(curr != null){
                System.out.print(curr.data+" ");
                curr = curr.next;
            }

            System.out.println();
        }
    }
    
    public static void main(){
        LinkedList ll = new LinkedList();
        ll.addFirst(10); // 10
        ll.addFirst(20); // 20 -> 10
        ll.addFirst(30); // 30 -> 20 -> 10
        System.out.println(ll.size());
        ll.display();
    }

}