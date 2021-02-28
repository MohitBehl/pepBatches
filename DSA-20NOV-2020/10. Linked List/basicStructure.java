import java.util.*;
public class basicStructure {
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
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
      }

      public void removeFirst(){
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
                tmp = tmp.next;
                idx--;
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
        }else if(idx == 0){
            addFirst(val);
        }else if(idx == size){
            addLast(val);
        }else{
            Node tmp = head;
            
            while(idx-1 != 0){
                tmp = tmp.next;
                idx--;
            }
            
            Node node = new Node();
            node.data = val;
            
            Node nextNbr = tmp.next;
            tmp.next = node;
            node.next = nextNbr;
            
            size++;
        }
      }

      public void removeLast(){
        if(size == 0){
            System.out.println("List is empty");
        }else if(size == 1){
            head=tail=null;
            size--;
        }else{
            Node tmp = head;
            while(tmp.next != tail){
                tmp = tmp.next;
            }
            
            tmp.next = null;
            tail = tmp;
            size--;
        }
      }

    public int kthFromLast(int k){
        Node slow = head , fast = head;
        // 1. maintain distance of k between slow & fast ptr
        while(k != 0){
            fast = fast.next;
            k--;
        }

        while(fast != tail){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public int mid(){
        Node slow = head, fast = head;
        
        while(fast.next != tail && fast != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        LinkedList res = new LinkedList();
        Node one = l1.head;
        Node two = l2.head;
        
        while(one != null && two != null){
            if(one.data < two.data){
                res.addLast(one.data);
                one = one.next;
            }else if(two.data < one.data){
                res.addLast(two.data);
                two = two.next;
            }else {
                res.addLast(one.data);
                res.addLast(two.data);
                one = one.next;
                two = two.next;
            }
        }
        
        while(one != null){
            res.addLast(one.data);
            one = one.next;
        }
        
        while(two != null){
            res.addLast(two.data);
            two = two.next;
        }
        return res;
      }
      
      public static LinkedList mergeSort(Node lo, Node hi){
        if(lo == hi){
            LinkedList base = new LinkedList();
            base.addLast(lo.data);
            return base;
        }    
        Node middle_node =  getMidNode(lo,hi);
        LinkedList lpart = mergeSort(lo,middle_node); // left part
        LinkedList rpart = mergeSort(middle_node.next,hi);// right part
        LinkedList res = mergeTwoSortedLists(lpart,rpart);
        return res;
      }

      public static Node getMidNode(Node st,Node ed){
        Node slow = st, fast = st;
        
        while(fast.next != ed && fast != ed){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
       }
   }
   
}
