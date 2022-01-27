import java.util.*;

class DLL {

  public static class DoublyLinkedList {
    private class Node {
      int data = 0;
      Node prev = null;
      Node next = null;

      Node(int data) {
        this.data = data;
      }

    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node curr = this.head;
      sb.append("[");
      while (curr != null) {
        sb.append(curr.data);
        if (curr.next != null)
          sb.append(", ");
        curr = curr.next;
      }
      sb.append("]");

      return sb.toString();
    }

    
    private boolean ListIsEmptyException() {
        if (this.size == 0) {
          System.out.print("ListIsEmpty: ");
          return true;
        }
        return false;
    }
    public void addFirst(int val) {
        Node node = new Node(val);
        
        if(size == 0){
            head = tail = node;
        }else{
            head.prev = node;
            node.next = head;
            head = node;
        }
        
        size++;
    }
    public void addLast(int val) {
        Node node = new Node(val);
        
        if(size == 0){
            head = tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        
        size++;
    }
    public int removeFirst() {
        if(size == 0){
            ListIsEmptyException();
            return -1;
        }else{
            int val = head.data;
            
            if(size == 1){
                head = tail = null;
            }else{
                Node nbr = head.next;
                head.next = null;
                nbr.prev = null;
                head = nbr;
            }
            size--;
            return val;
        }
    }
    public int removeLast() {
        if(size == 0){
            ListIsEmptyException();
            return -1;
        }else{
            int val = tail.data;
            
            if(size == 1){
                head = tail = null;
            }else{
                Node nbr = tail.prev;
                nbr.next = null;
                tail.prev = null;
                tail = nbr;
            }
            size--;
            return val;
        }
    }

    public int getFirst() {
        if(size == 0){
            ListIsEmptyException();
            return -1;
        }else{
            return head.data;
        }
    }

    public int getLast() {
        if(size == 0){
            ListIsEmptyException();
            return -1;
        }else{
            return tail.data;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeAt(int index) {
        if(ListIsEmptyException()){
            return -1;
        }else if(indexIsInvalidException(index,0,size-1)){
            return -1;
        }else{
            if(index == 0){
                return removeFirst();
            }else if(index == size-1){
                return removeLast();
            }else{
                Node curr = head;
                
                while(index != 0){
                    curr = curr.next;
                    index--;
                }
                
                Node pnbr = curr.prev;
                Node nnbr = curr.next;
                pnbr.next = nnbr;
                nnbr.prev = pnbr;
                curr.next = null;
                curr.prev = null;
                
                size--;
                return curr.data;
            }
        }
    }

    public void addAt(int index, int data) {
        if(indexIsInvalidException(index,0,size)){
            System.out.println("-1");
            return;
        }else{
            if(index == 0){
                addFirst(data);
            }else if(index == size){
                addLast(data);
            }else{
                index--;
                Node tmp = head;
                while(index != 0){
                    tmp = tmp.next;
                    index--;
                }
                
                Node nbr = tmp.next;
                Node node = new Node(data);
                tmp.next = node;
                node.prev = tmp;
                node.next = nbr;
                nbr.prev = node;
                
                size++;
            }
        }
    }

    public int getAt(int index) {
        if(ListIsEmptyException()){
            return -1;   
        }else if(indexIsInvalidException(index,0,size-1)){
            return -1;
        }else{
            Node curr = head;
            while(index != 0){
                curr = curr.next;
                index--;
            }
            return curr.data;
        }
    }

    public void addBefore(Node refNode, int data) {
        Node node = new Node(data);
        Node nbr = refNode.prev;
        if(nbr == null){
            // add first
            node.next = refNode;
            refNode.prev = node;
            
            head = node;
        }else{
            nbr.next = node;
            node.prev = nbr;
            
            refNode.prev = node;
            node.next = refNode;
        }
        
        size++;
    }

    public void addBefore(int idx, int data) {
        Node node = getNodeAt(idx);
        addBefore(node, data);
    }

    public void addAfter(Node refNode, int data) {
        Node node = new Node(data);
        Node nbr = refNode.next;
        
        if(nbr == null){
            refNode.next = node;
            node.prev = refNode;
            tail = node;
        }else{
            node.next = nbr;
            nbr.prev = node;
            
            refNode.next = node;
            node.prev = refNode;
        }
        
        size++;
    }

    public void addAfter(int idx, int data) {
        Node node = getNodeAt(idx);
        addAfter(node, data);
    }

    public int removeAfter(Node refNode) {
        if(refNode.next == null){
            System.out.println("LocationIsInvalid: ");
            return -1;
        }else{
            Node fwd = refNode.next;
            
            if(fwd.next == null){
                fwd.prev = null;
                refNode.next = null;
                tail = refNode;
            }else{
                refNode.next = fwd.next;
                fwd.next.prev = refNode;
                fwd.next = null;
                fwd.prev = null;
            }
            
            size--;
            return fwd.data;
        }
    }

    public int removeAfter(int idx) {
        Node node = getNodeAt(idx);
        return removeAfter(node);
    }

    public int removeNode(Node refNode) {
        if(refNode == null){
            System.out.println("LocationIsInvalid: ");
            return -1;
        }else{
            Node prv = refNode.prev;
            Node fwd = refNode.next;
            
            if(prv == null && fwd == null){
                head = tail = null;
            }else if(fwd == null){
                // remove tail
                prv.next = null;
                refNode.prev = null;
                
                tail = prv;
            }else if(prv == null){
                // remove head
                refNode.next = null;
                fwd.prev = null;
                
                head = fwd;
            }else{
                prv.next = fwd;
                fwd.prev = prv;
                
                refNode.next = null;
                refNode.prev = null;
            }
              
            size--;
            return refNode.data;
        }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    DoublyLinkedList dll = new DoublyLinkedList();

    String str = scn.nextLine();
    while (!str.equals("stop")) {
      String[] s = str.split(" ");
      if (s[0].equals("addFirst"))
        dll.addFirst(Integer.parseInt(s[1]));

      str = scn.nextLine();
    }
    System.out.println(dll);
  }
}