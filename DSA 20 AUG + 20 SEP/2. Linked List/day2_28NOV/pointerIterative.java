public class pointerIterative {
    public void reversePI(){
        Node curr = head;
        Node prev = null;
        
        while(curr != null){
            Node nextPtr = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = nextPtr;
        }
        
        Node tmp = head;
        head = tail;
        tail = tmp;
      }
}
