import java.util.*;

class MergeSort {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        
        ListNode res = new ListNode(-1); //  dummy
        ListNode tail = res;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if(l1 != null){
            tail.next = l1;
        }else{
            tail.next = l2;
        }
        
        return res.next;
    }
    
    public static ListNode midNodeOfLinkedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode s = head , f = head;
        
        while(f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }
        
        return s;
    }
    
    public static ListNode mergeSort(ListNode head) {
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            return new ListNode(head.val);    
            // return head;
        }
        
        ListNode midNode = midNodeOfLinkedList(head);
        ListNode fwd = midNode.next;
        midNode.next = null;
        
        ListNode lHead = mergeSort(head);
        ListNode rHead = mergeSort(fwd);
        
        midNode.next = fwd;
        
        return mergeTwoLists(lHead,rHead);
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

        ListNode head = mergeSort(h1);
        printList(head);
    }
}