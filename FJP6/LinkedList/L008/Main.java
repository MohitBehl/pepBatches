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