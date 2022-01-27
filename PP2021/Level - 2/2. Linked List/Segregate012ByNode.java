import java.util.*;

class Segregate012ByNode {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dOne = new ListNode(-1);
        ListNode dZero = new ListNode(-1);
        ListNode dTwo = new ListNode(-1);
        ListNode po = dOne , pz = dZero , pt = dTwo , curr = head;
        
        while(curr != null){
            if(curr.val == 1){
                po.next = curr;
                po = po.next;
            }else if(curr.val == 0){
                pz.next = curr;
                pz = pz.next;
            }else{
                pt.next = curr;
                pt = pt.next;
            }
            curr = curr.next;
        }
        
        po.next = dTwo.next;
        pz.next = dOne.next;
        pt.next = null;
        
        return dZero.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate012(h1);
        printList(h1);
    }
}