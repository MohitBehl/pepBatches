package NIET;

class Main{
    public static class Node{
        int data;
        Node next;
        
        public Node() {
        }

        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    
    public class LinkedList{
        Node head  ,tail;
        int size;
    
        void addLast(int val) {
            Node node = new Node(val, null);
            node.data = val;

            if(size == 0){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public int size(){
            return size;
        }

        public void display(){
            Node tmp = head;
            while(tmp != null){
                System.out.print(tmp.data+" ");
                tmp = tmp.next;
            }
            System.out.println();
        }
        public void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
            }else if(size == 1){
                head = tail = null;
                size = 0;
            }else{
                Node nbr = head.next; // nbr -> new head
                head.next = null; // connection break
                head = nbr;
                size--;
            }
        }

        public int getFirst(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else{
                return head.data;
            }
        }

        public int getLast(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else{
                return tail.data;
            }
        }

        public int getAt(int idx){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return -1;
            }else{
                Node tmp = head;
                while(idx != 0){
                    idx--;
                    tmp = tmp.next;
                }
                return tmp.data;
            }
        }

        public void addFirst(int val) {
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

        public void addAt(int idx, int val){
            if(idx < 0 || idx > size){
                System.out.println("Invalid arguments");
            }else {
                if(idx == 0){
                    addFirst(val);
                }else if(idx == size){
                    addLast(val);
                }else{
                    Node node = new Node();
                    node.data = val;
                    
                    Node tmp = head;
                    while(idx > 1){
                        idx--;
                        tmp = tmp.next;
                    }                    
                    Node nbr = tmp.next;
                    
                    tmp.next = node;
                    node.next = nbr;
                    size++;
                    }
                }
            }

            public void removeAt(int idx) {
                if(size == 0){
                    System.out.println("List is empty");
                }else if(idx < 0 || idx >= size){
                    System.out.println("Invalid arguments");
                }else{
                    if(idx == 0){
                        removeFirst();
                    }else if(idx == size-1){
                        removeLast();
                    }else{
                        Node tmp = head;
                        while(idx > 1){
                            tmp = tmp.next;
                            idx--;
                        }
                        Node nbr = tmp.next;
                        
                        tmp.next = nbr.next;
                        nbr.next = null;
                        size--;
                    } 
                }
            }

            private void removeLast() {
            }
    }
    
    public static void main(String args[]){
        LinkedList list = new LinkedList();
    }

    
}