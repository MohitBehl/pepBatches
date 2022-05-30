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
    
    public ListNode getMid(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode slow = head , fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode nbr = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = nbr;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        
        head2 = reverse(head2);
    
        ListNode p1 = head , p2 = head2;
        
        ListNode dummy = new ListNode();
        
        ListNode p3 = dummy;
        
        
        while(p1 != null && p2 != null){
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
            
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        
        p3.next = p1; // odd
    }
}