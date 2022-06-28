// https://leetcode.com/problems/design-linked-list/
class MyLinkedList {
    private class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
            this.next = this.prev = null;
        }
    } 
    private Node head , tail;
    private int size;
    
    public MyLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        
        Node curr = this.head;
        while(index != 0){
            index--;
            curr = curr.next;
        }
        
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(this.size() == 0){
            this.head = this.tail = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        this.size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(this.size() == 0){
            this.head = this.tail = node;
        }else{
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(idx < 0 || idx > size) return;
        else if(idx == 0) addAtHead(val);
        else if(idx == size) addAtTail(val);
        else{
            Node curr = this.head;
            while(index != 0){
                curr = curr.next;
                index--;
            }
            
            Node pnode = curr.prev;
            Node node = new Node(val);
            
            node.next = curr;
            curr.prev = node;
            pnode.next = node;
            node.prev = pnode;
            this.size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        // HW
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */