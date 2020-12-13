public class Node{
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
}
