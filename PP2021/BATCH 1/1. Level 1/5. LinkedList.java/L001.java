public class L001 {
    
    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        Node head,tail;
        int size;

        void addLast(int val) {
            // create a Node
            Node node = new Node(); //  default values
            node.data = val;
            
            if(this.size == 0){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }

            this.size++;
        }

        void display(){
            Node tmp = head;

            while(tmp != null){
                System.out.print(tmp.data+"->");
                tmp = tmp.next;
            }
            System.out.println(".");
        }

        void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
            }else{
                if(size == 1){
                    head = tail = null;
                }else{
                    Node tmp = head.next;
                    head.next = null;
                    head = tmp;
                }
                size--;
            }
        }

        int getFirst(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else{
                return head.data;
            }
        }

        int getLast(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else{
                return tail.data;
            }
        }

        int getAt(int idx){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return -1;
            }else{
                Node tmp = head;

                while(idx > 0){
                    tmp = tmp.next;
                    idx--;
                }
                return tmp.data;
            }
        }

        void addFirst(int val){
            Node node = new Node();
            node.data = val;

            if(size == 0){
                head = tail = node;
            }else{
                node.next = head;
                head = node;
            }

            size++;
        }

        void addAt(int idx , int val){
            if(idx < 0 || idx > size){
                // invalid arg.
                System.out.println("Invalid arguments");
            }else{
                if(idx == 0){
                    addFirst(val);
                }else if(idx == size){
                    addLast(val);
                }else{
                    Node tmp = head;
                    for(int jmp = 1 ; jmp <= idx-1 ; jmp++){
                        tmp = tmp.next;
                    }

                    Node nbr = tmp.next;

                    Node node = new Node();
                    node.data = val;

                    tmp.next = node;
                    node.next = nbr;

                    size++;
                }
            }
        }

        void removeLast(){
            if(size == 0){
                System.out.println("List is empty");
            }else {
                if(size == 1){
                    head = tail = null;
                }else{

                    Node tmp = head;

                    while(tmp.next != tail){
                        tmp = tmp.next;
                    }

                    tmp.next = null;
                    tail = tmp;
                }
                size--;
            }
        }

        void removeAt(int idx){
            if(size == 0){
                System.out.println("List is Empty");
            }else if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
            }else if(idx == 0){
                removeFirst();
            }else if(idx == size-1){
                removeLast();
            }else{
                Node tmp = head;
                for(int i = 1 ; i <= idx-1 ; i++){
                    tmp = tmp.next;
                }

                Node nbr = tmp.next;
                Node newNbr = nbr.next;
                
                nbr.next = null;
                tmp.next = newNbr;
                size--;
            }         
        }

        Node getNodeAt(int idx){
            if(size == 0){
                System.out.println("List is empty");
                return null;
            }else if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return null;
            }else{
                Node tmp = head;

                while(idx > 0){
                    tmp = tmp.next;
                    idx--;
                }
                return tmp;
            }
        }
        void reverseDI() {
            int p1 = 0 , p2 = size-1;

            while(p1 < p2){
                Node n1 = getNodeAt(p1);
                Node n2 = getNodeAt(p2);

                int tData = n1.data;
                n1.data = n2.data;
                n2.data = tData;
                
                p1++;
                p2--;
            }
        }

        void reversePI(){
            Node curr = head , prev = null;

            while(curr != null){
                Node nbr = curr.next;

                curr.next = prev;

                prev = curr;
                curr = nbr;
            }

            Node tmp = head;
            head = tail;
            tail = tmp;
        }
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.display();

        System.out.println("last value : " + ll.getLast());
        System.out.println("first value : " + ll.getFirst());
        System.out.println("value at idx = 3 : " + ll.getAt(3));
    }
}
