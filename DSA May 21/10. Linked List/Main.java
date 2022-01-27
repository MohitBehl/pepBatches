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
        public void removeLast() {
            if (size == 0) {
              System.out.println("List is empty");
            } else if (size == 1) {
              head = tail = null;
              size = 0;
            } else {
              Node temp = head;
              for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
              }
      
              tail = temp;
              tail.next = null;
              size--;
            }
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
        public int kthFromLast(int k){
            Node curr , fwd;
            curr = fwd = head;
    
            while(k != 0){
                fwd = fwd.next;
                k--;
            }
    
            while(fwd.next != null){
                fwd = fwd.next;
                curr = curr.next;
            }
    
            return curr.data;
        }

        public int mid(){
            Node fast , slow;
            fast = slow = this.head;

            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow.data;
        }

        public static int findIntersection(LinkedList one, LinkedList two){
            Node p1 = one.head , p2 = two.head;

            if(one.size > two.size){
                int diff = one.size - two.size;
                while(diff > 0){
                    p1 = p1.next;
                    diff--;
                }
            }else if(one.size < two.size){
                int diff = two.size - one.size;
                while(diff > 0){
                    p2 = p2.next;
                    diff--;
                }
            }

            while(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1.data;
        }

        public void removeDuplicates(){
            // this -> original input
            LinkedList ll = new LinkedList();
            ll.addLast(this.getFirst());
            
            while(this.size != 0){
                if(this.getFirst() == ll.getLast()){
                    this.removeFirst();
                }else{
                    ll.addLast(this.getFirst());
                }    
            }

            this.head = ll.head;
            this.tail = ll.tail;
            this.size = ll.size;
        }

        public void oddEven(){
            LinkedList odd = new LinkedList() , even = new LinkedList();

            while(this.size != 0){
                int vl = this.getFirst();
                this.removeFirst();

                if(vl % 2 == 0){
                    // even
                    even.addLast(vl);
                }else{
                    // odd
                    odd.addLast(vl);
                }
            }
            if(odd.size != 0 && even.size != 0){
                // odd & even elements exists
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            }else if(even.size != 0){
                // only even elements exists
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }else if(odd.size != 0){
                // only odd elements exists
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList sll = new LinkedList();

            Node p1 = l1.head , p2 = l2.head;

            while(p1 != null && p2 != null){
                if(p1.data <= p2.data){
                    sll.addLast(p1.data);
                    p1 = p1.next;
                }else{
                    sll.addLast(p2.data);
                    p2 = p2.next;
                }
            }

            while(p1 != null){
                sll.addLast(p1.data);
                p1 = p1.next;
            }

            while(p2 != null){
                sll.addLast(p2.data);
                p2 = p2.next;
            }

            return sll;
        }

        public static Node midNode(Node head,Node tail) {
            Node f = head;
            Node s = head;
      
            while (f !=  tail&& f.next != tail) {
              f = f.next.next;
              s = s.next;
            }
      
            return s;
        }
      
        public static LinkedList mergeSort(Node head, Node tail){
            if(head == tail){
                LinkedList b = new LinkedList();
                b.addLast(head.data);
                return b;
            }
            
            Node mid = midNode(head,tail);
            LinkedList left = mergeSort(head,mid);
            LinkedList right = mergeSort(mid.next,tail);
            
            return mergeTwoSortedLists(left,right);
        }

    }


    public static void main(String[] args){
        LinkedList ll = new LinkedList();
    }
}
