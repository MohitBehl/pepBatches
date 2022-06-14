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

        public void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
                return;
            }else if(size == 1){
                head = tail = null;
                size = 0;
            }else{
                head = head.next;
                size--;
            }
        }

        public int mid(){
            Node fast = head , slow = head;

            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow.data;
        }

        public int kthFromLast(int k){
           Node curr = head , front = head;

           // head start
           while(k != 0){
                front = front.next;
                k--;
           }

           // start the race
           while(front.next != null){
                front = front.next;
                curr = curr.next;
           }

           return curr.data;
        }
        public int getAt(int idx){
            // write your code here
            if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return -1;
            }
            Node temp = head;
            for(int i = 1; i <= idx; i++){
                temp = temp.next;
            }
            return temp.data;
        }

        public Node getNodeAt(int idx){
            // write your code here
            if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return null;
            }
            Node temp = head;
            for(int i = 1; i <= idx; i++){
                temp = temp.next;
            }
            return temp;
        }
        public void reverseDI() {
            int left = 0 , right = size-1;

            while(left < right){
                Node lnode = getNodeAt(left);
                Node rnode = getNodeAt(right);

                int tmp = lnode.data;
                lnode.data = rnode.data;
                rnode.data = tmp;

                left++;
                right--;
            }
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