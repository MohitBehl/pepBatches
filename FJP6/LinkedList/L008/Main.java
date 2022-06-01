public class Main{
    // unfold a linked list
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public static void unfold(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) 
            return;
        
        ListNode d1 = new ListNode(-1);
        ListNode d2 = new ListNode(-1);

        ListNode p1 = d1 , p2 = d2 , p3 = head;
        boolean flag = true;
        while(p3 != null){
            if(flag){ // ll1
                p1.next = p3;
                p1 = p1.next;
            }else{ // ll2
                p2.next = p3;
                p2 = p2.next;
            }
            p3 = p3.next;
            flag = !flag;
        }

        p1.next = null;
        p2.next = null;

        ListNode head2 = d2.next;
        head2 = reverse(head2);

        // ListNode ptr = head;
        // while(ptr.next != null){
        //     ptr = ptr.next;
        // }
        // ptr.next = head2;
        p1.next = head2;
    }
}

// segregate even odd
/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution{
    Node divide(int N, Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node even = new Node(0);
        Node odd = new Node(0);

        Node evenTail = even , oddTail = odd;
        Node curr = head;

        while(curr != null){
            if(curr.data % 2 == 0){
                evenTail.next = curr;
                evenTail = evenTail.next;
            }else {
                oddTail.next = curr;
                oddTail = oddTail.next;
            }
            curr = curr.next;
        }

        oddTail.next = null;
        evenTail.next = null;

        evenTail.next = odd.next;

        return even.next;
    }


}

// rotate a linked list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int size(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){ return head;}
        int len = size(head);
        k = k % len;
        if(k == 0) return head;
        
        ListNode slow = head , fast = head;
        while(k != 0){
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode nbr = slow.next;
        slow.next = null;
        fast.next = head;
        return nbr;
    }
}