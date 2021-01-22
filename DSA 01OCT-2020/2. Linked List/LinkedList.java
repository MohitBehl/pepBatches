import java.util.LinkedList;

class Node{
    int data;
    Node next;
}
public class LinkedList {
    Node head;
    Node tail;
    int size;

    public void addLast(int val) {
      Node node = new Node();
      node.data = val;
      
      if(size == 0){
          // first node to be added
          head = tail = node;
      }else{
          tail.next = node;
          tail = node;
      }
      
      size++;
    }

    public int size(){
        return this.size;
    }
  
      public void display(){
      Node node = head;
        
       while(node != null){
          System.out.print(node.data+" ");
          node = node.next;
       }
       System.out.println();
    }
      
      public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
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
        }else{
            if(idx >= 0 && idx <= size-1){
                if(idx == 0){
                    return getFirst();
                }else if(idx == size-1){
                    return getLast();
                }else{
                    Node tmp = head;
                    
                    for(int jmp = 1 ; jmp <= idx ; jmp++){
                        tmp = tmp.next;
                    }
                    
                    return tmp.data;
                }
            }else{
                System.out.println("Invalid arguments");
                return -1;
            }
        }
      }

      public void addFirst(int val) {
        Node node = new Node();
        node.data = val;
        
        if(size == 0){
            head = tail = node; 
        }else{
            node.next = head; // new node --> current st point
            head = node; // changing st point
        }
        
        size++;
      }

      public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
        }else if (idx == 0) {
            addFirst(val);
        }else if (idx == size) {
            addLast(val);
        }else if (idx > 0 && idx < size) {
            Node pre = head;
            for(int jmp = 1 ; jmp <= idx -1 ; jmp++){
                pre = pre.next;
            }
            
            Node node = new Node();
            node.data = val;
            
            node.next = pre.next;
            pre.next = node;
            size++;
        }
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
        if (size == 0) {
            System.out.println("List is empty");
        } else
        if (idx < 0 || idx > size - 1) {
            System.out.println("Invalid arguments");
        } else {
            if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node pre = head;
                
                for(int jmp = 1 ; jmp <= idx - 1 ; jmp++){
                    pre = pre.next;
                }
                
                Node newNextNode = pre.next.next;
                pre.next.next = null;
                pre.next = newNextNode;
                
                size--;
            }
        }
    }


    public int kthFromLast(int k){
        Node slow = head , fast = head;

        // fast ptr K times ahead of slow

        for(int jmp = 1 ; jmp <= k ; jmp++){
            fast = fast.next;
        }

        while(fast != tail){
            fast = fast.next;
            slow = slow.next;
        }

        // fast --> tail , slow --> kth node from tail
        return slow.data;
    }

    public int mid(){
        Node fast = head ,  slow = head;
        
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow.data;
    }

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        LinkedList l3 = new LinkedList();
        Node p1 = l1.head;
        Node p2 = l2.head;

        // logic --> merge
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                l3.addLast(p1.data);
                p1 = p1.next;
            } else {
                l3.addLast(p2.data);
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            l3.addLast(p1.data);
            p1 = p1.next;
        }

        while (p2 != null) {
            l3.addLast(p2.data);
            p2 = p2.next;
        }
        return l3;
    }

    public void oddEven(){
      
        LinkedList even = new LinkedList() , odd = new LinkedList();
        
        while(this.size > 0){
            int val = getFirst();
            removeFirst();
            
            if(val % 2 == 0){
                // even
                even.addLast(val);
            }else{
                // odd
                odd.addLast(val);
            }
        }
        
        if(odd.size() == 0){
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size();
        }else if(even.size() == 0){
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size();
        }else if(odd.size() != 0 && even.size() != 0){
            // merging
            odd.tail.next = even.head;
            
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size() + even.size();
        }
    }

    public void removeDuplicates(){
        LinkedList ll = new LinkedList();
        
        ll.addLast(this.getFirst());
        this.removeFirst();
        
        while(this.size > 0){
           int currVal = this.getFirst();
           
           this.removeFirst();
           if(currVal != ll.getLast()){
              // currVal --> unique value 
              ll.addLast(currVal);
           }
        }
        
        this.head = ll.head;
        this.tail = ll.tail;
        this.size = ll.size;
      }

      public void reversePI(){
        Node curr = head , prev = null;

        while(curr != null){
            Node nxt = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nxt;
        }

        Node tmp = this.head;
        this.head = this.tail;
        this.tail = tmp;
      }

    public Node getNodeAt(int idx){
        Node tmp = head;
        
        for(int jmp = 1 ; jmp <= idx ; jmp++){
            tmp = tmp.next;
        }
        
        return tmp;
    }
    public void reverseDI() {
      int lo = 0 , hi = this.size-1;
      
      while(lo < hi){
          Node left = getNodeAt(lo);
          Node right = getNodeAt(hi);
          
          int tmp = left.data;
          left.data = right.data;
          right.data = tmp;
          
          lo++;
          hi--;
      }
    }

    private void displayReverseHelper(Node node){
        if(node == null){
            return;
        }
        displayReverseHelper(node.next);
        
        System.out.print(node.data+" ");
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
        
        if(node != tail){
            node.next.next = node;
        }
      }
  
      public void reversePR(){
        reversePRHelper(this.head);
      
        head.next = null;
        
        Node tmp = this.head;
        this.head = this.tail;
        this.tail = tmp;
      }

      static Node leftNode;
      public void reverseDRHelper(Node node,int idx){
          if(node == null){
              return;
          }
          
          reverseDRHelper(node.next,idx+1);
          
          if(idx >= size/2){
              Node rightNode = node;
              
              int tmp = leftNode.data;
              leftNode.data = rightNode.data;
              rightNode.data = tmp;
              
              leftNode = leftNode.next;
          }
      }
      public void reverseDR() {
        leftNode = head;
        reverseDRHelper(head,0);
      }

      static Node leftNode;
        public boolean IsPalindrome() {
            leftNode = head;
            return IsPalindromeHelper(head, 0);
        }

        public boolean IsPalindromeHelper(Node node, int idx) {
            if (node == null) {
                return true;
            }

            boolean res = IsPalindromeHelper(node.next, idx + 1);

            if (res == false) {
                return false;
            }
            if (idx >= size / 2) {
                Node rightNode = node;
                if (leftNode.data == rightNode.data) {
                    leftNode = leftNode.next;
                    return true;
                } else {
                    return false;
                }
            }
            
            return true;

        }


        public void kReverse(int k) {
            LinkedList tmpList = new LinkedList();
            LinkedList kRevList = new LinkedList();

            while(this.size > 0){
                if(this.size >= k){
                    // k reverse possible --> element's k rev order
                    for(int i = 1 ; i <= k ; i++){
                        int ele = this.getFirst();
                        this.removeFirst();
                        tmpList.addFirst(ele);
                    }

                }else{
                    // k reverse not possible --> element's org order
                        while(this.size>0){
                            int ele = this.getFirst();
                            this.removeFirst();
                            tmpList.addLast(ele);
                        }
                }
                
                if(kRevList.size == 0){
                    //
                    kRevList = tmpList;
                    tmpList = new LinkedList();
                }else{
                    // tmpList merges with kRevList
                    kRevList.tail.next = tmpList.head;
                    kRevList.size += tmpList.size;
                    kRevList.tail = tmpList.tail;
                    tmpList = new LinkedList();
                }
            }

            // kRevList --> main List
            this.head = kRevList.head;
            this.tail = kRevList.tail;
            this.size = kRevList.size;
        }

        public static int findIntersection(LinkedList one, LinkedList two){
            Node p1 = one.head , p2 = two.head;
            if(one.size > two.size){
                int diff = one.size - two.size;
                
                while(diff > 0){
                    p1 = p1.next;
                    diff--;
                }
            }else if(two.size > one.size){
                int diff =  two.size - one.size;
                
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

    static Node left;
    public void foldHelper(Node node , int idx){
        if(node == null){
            return;
        }
        foldHelper(node.next,idx+1);
        Node right = node;
        
        if(idx > this.size/2){
            
            Node tmp = left.next;
            left.next = right;
            right.next = tmp;
            
            left = tmp;
        }else if(idx == this.size/2){
            right.next = null;
            this.tail = right;
        }
    }
    public void fold() {
      left = head;
      foldHelper(head,0);
    }

    public static class LLToStackAdapter {
        LinkedList<Integer> list;
    
        public LLToStackAdapter() {
          list = new LinkedList<>();
        }
    
    
        int size() {
          return list.size();
        }
    
        void push(int val) {
          list.addFirst(val);
        }
    
        int pop() {
          if(list.size() == 0){
              System.out.println("Stack underflow");
              return -1;
          }
          
          int ele = list.getFirst();
          list.removeFirst();
          return ele;
        }
    
        int top() {
          if(list.size() == 0){
              System.out.println("Stack underflow");
              return -1;
          }
          
          int ele = list.getFirst();
          return ele;
        }
      }

      public static class LLToQueueAdapter {
        LinkedList list;
    
        public LLToQueueAdapter() {
          list = new LinkedList<>();
        }
    
        int size() {
          return list.size();
        }
    
        void add(int val) {
          list.addLast(val);
        }
    
        int remove() {
          if(list.size() == 0){
              System.out.println("Queue underflow");
              return -1;
          }
          int ele = list.getFirst();
          list.removeFirst();
          
          return ele;
        }
    
        int peek() {
          // write your code here
          if(list.size() == 0){
              System.out.println("Queue underflow");
              return -1;
          }
          int ele = list.getFirst();
          
          return ele;
        }
      }
}
