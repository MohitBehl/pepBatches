public class Main{
    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        int size;
        Node head,tail;

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
                head = tail = null;
            }else{
              Node nbr = this.head.next;
              this.head.next = null;
              this.head = nbr;
            }
            this.size--;
        }

        public int getFirst(){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }
    
        public int getLast(){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;
        }
    
        public int getAt(int idx){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }
            if(idx < 0 || idx >= this.size){
                System.out.println("Invalid arguments");
                return -1;
            }

            Node tmp = head;
            while(idx > 0){
                tmp = tmp.next;
                idx--;
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

        public void removeLast(){
            if(this.size == 0){
                System.out.println("List is empty");
                return;
            }

            if(this.size == 1){
                this.head = this.tail = null;
            }else{
                Node tmp = head;
                while(tmp.next != tail){
                    tmp = tmp.next;
                }

                tmp.next = null;
                tail = tmp;
            }
            this.size--;
        }

        public void addAt(int idx, int val){
            if(idx < 0 || idx > size){
                System.out.println("Invalid arguments");
                return;
            }
            if(idx == 0){
                addFirst(val);
            }else if(idx == size){
                addLast(val);
            }else{
                Node node = new Node();
                node.data = val;
                
                Node tmp = head;
                
                while(idx > 1){
                    tmp = tmp.next;
                    idx--;
                }
                
                node.next = tmp.next;
                tmp.next = node;
                
                this.size++;
            }
        }

        public void removeAt(int idx) {
            if(this.size == 0){
                System.out.println("List is empty");
                return;
            }
            
            if(idx < 0 || idx >= size){
                System.out.println("Invalid arguments");
                return;
            }
            
            if(idx == 0){
                this.removeFirst();
            }else if(idx == size-1){
                this.removeLast();
            }else{
                Node tmp = head;
                
                while(idx > 1){
                    tmp = tmp.next;
                    idx--;
                }
                
                Node nbr = tmp.next;
                tmp.next = nbr.next;
                nbr.next = null;
                
                this.size--;
            }
        }
    
        public Node getNodeAt(int idx){
            if(this.size == 0){
                // System.out.println("List is empty");
                return null;
            }
            if(idx < 0 || idx >= this.size){
                // System.out.println("Invalid arguments");
                return null;
            }

            Node tmp = head;
            while(idx > 0){
                tmp = tmp.next;
                idx--;
            }
            return tmp;
        }
        public void reverseDI() {
            int lp = 0 , rp = this.size-1;

            while(lp < rp){
                Node left = getNodeAt(lp);
                Node right = getNodeAt(rp);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                lp++;
                rp--;
            }
        }

        static Node leftRev;
        public void reverseDR() {
            leftRev = head;
            reverseDRHelper(head,0);
        }

        public void reverseDRHelper(Node node,int idx){
            if(node == null){
                return;
            }
            reverseDRHelper(node.next,idx+1);
            
            if(idx >= this.size/2){
                Node right = node;
                
                int temp = right.data;
                right.data = leftRev.data;
                leftRev.data = temp;
                
                leftRev = leftRev.next;
            }
        }
    }
    
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
    }
}
