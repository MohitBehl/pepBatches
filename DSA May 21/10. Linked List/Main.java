public class Main {
    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        Node head , tail;
        int size;

        void addLast(int val) {
            Node node = new Node();
            node.data = val;

            if(this.size == 0){
                this.head = this.tail = node;
            }else{
                this.tail.next = node;
                this.tail = node;
            }
            this.size++;
        }

        public int size(){
            return this.size;
        }
    
        public void display(){
            Node tmp = this.head;

            while(tmp != null){
                System.out.print(tmp.data+" ");
                tmp = tmp.next;
            }

            System.out.println();
        }

        public void removeFirst(){
            if(this.size == 0){
                System.out.println("List is empty");
                return;
            }else if(this.size == 1){
                this.head = this.tail = null;
                this.size = 0;
            }else{
                Node fwd = this.head.next;
                this.head.next = null;
                this.head = fwd;
                this.size--;
            }
        }

        public int getFirst(){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }
            return this.head.data;
        }
    
        public int getLast(){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }
            return this.tail.data;
        }
    
        public int getAt(int idx){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }
            if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return -1;
            }

            Node tmp = head;
            while(idx != 0){
                idx--;
                tmp = tmp.next;
            }

            return tmp.data;
        }

        public void addFirst(int val) {
            Node node = new Node();
            node.data = val;

            if(this.size == 0){
                this.head = this.tail = node;
            }else{
                node.next = this.head;
                this.head = node;
            }
            this.size++;
        }

        public void removeAt(int idx) {
            if(this.size() == 0){
                System.out.println("List is empty");
                return;
            }
            if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return;
            }
            if(idx == 0){
                removeFirst();
            }else if(idx == size-1){
                removeLast();
            }else{
                Node tmp = this.head;
                while(idx-1 != 0){
                    idx--;
                    tmp = tmp.next;
                }
                
                Node nbr = tmp.next;
                tmp.next = nbr.next;
                nbr.next = null;
                
                this.size--;
            }
        }
    }


    public static void main(String[] args){
        LinkedList ll = new LinkedList();
    }
}
