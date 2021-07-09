import java.util.*;

class Segregate012ByData {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void swap(ListNode l1 , ListNode l2){
        int tmp = l1.val;
        l1.val = l2.val;
        l2.val = tmp;
    }
    public static ListNode segregate012(ListNode head) {
        
        ListNode i = head , j = head , k = head;
        
        while(i != null){
            if(i.val == 2){
                i = i.next;
            }else if(i.val == 1){
                swap(i,k);
                i = i.next;
                k = k.next;
            }else{
                swap(i,j);
                if(i.val == 1){
                    swap(i,k);
                }
                i = i.next;
                k = k.next;
                j = j.next;
            }
        }
        
        return head;
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