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
    
        public int kthFromLast(int k){
            Node fwd = this.head;
            while(k > 0){
                fwd = fwd.next;
                k--;
            }

            Node curr = this.head;
            while(fwd != tail){
                fwd = fwd.next;
                curr = curr.next;
            }

            return curr.data;
        }

        public int mid(){
            Node slow = head, fast = head;

            while(fast != tail && fast.next != tail){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow.data;
        }

        public void removeDuplicates(){
            LinkedList ll = new LinkedList();
            ll.addFirst(this.getFirst());
            
            while(this.size() > 0){
                if(ll.getLast() == this.getFirst()){
                    this.removeFirst();
                }else{
                    ll.addLast(this.getFirst());
                    this.removeFirst();
                }
            }

            this.head = ll.head;
            this.tail = ll.tail;
            this.size = ll.size;
        }

        public void oddEven(){
            // HW
        }
        public void kReverse(int k) {
            LinkedList ans = new LinkedList();
            LinkedList curr = new LinkedList();
            
            while(this.size() > 0){
                if(this.size() >= k){
                    // grouping possible
                    int i = 1;
                    while(i <= k){
                        curr.addFirst(this.getFirst());
                        this.removeFirst();
                        i++;
                    }
                }else{
                    while(this.size() > 0){
                        curr.addLast(this.getFirst());
                        this.removeFirst();
                    }
                }


                if(ans.size() == 0){
                    ans = curr;
                }else{
                    ans.tail.next = curr.head;
                    ans.tail = curr.tail;
                    ans.size += curr.size;
                }                
                curr = new LinkedList();
            }

            this.head = ans.head;
            this.tail = ans.tail;
            this.size = ans.size;
        }
        public void displayReverse(){
            displayReverseHelper(head);
            System.out.println();
        }

        private void reversePRHelper(Node node){
            if(node == null){
                return;
            }
            reversePRHelper(node.next);
            if(node != this.tail){
                node.next.next = node;
            }
        }
    
        public void reversePR(){
            reversePRHelper(head);
            
            Node tmp = this.head;
            this.head = this.tail;
            this.tail = tmp;
            
            this.tail.next = null;
        }
    }
    
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
    }
}
