/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        
        while(curr != null){
            Node nbr = curr.next;
            Node clone = new Node(curr.val);
            curr.next = clone;
            clone.next = nbr;
            curr = nbr;
        }
        
        curr = head;
        
        while(curr != null){
            Node clone = curr.next;
            if(curr.random != null)
            clone.random = curr.random.next;
            curr = curr.next.next;
        }
        
        Node dummy = new Node(0);
        Node dptr = dummy;
        curr = head;
        while(curr != null){
            Node clone = curr.next;
            dptr.next = clone;
            curr.next = curr.next.next;
            
            dptr = clone;
            curr = curr.next;
        }
        return dummy.next;
    }
}