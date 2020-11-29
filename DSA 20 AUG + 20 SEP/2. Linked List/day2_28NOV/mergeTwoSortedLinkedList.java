public class mergeTwoSortedLinkedList {
    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        LinkedList res = new LinkedList();
        
        Node p1 = l1.head;
        Node p2 = l2.head;
        
        while(p1 != null && p2 != null){
            if(p1.data < p2.data){
                res.addLast(p1.data);
                p1 = p1.next;
            }else{
                res.addLast(p2.data);
                p2 = p2.next;
            }
        }
        
        while(p2 != null){
            res.addLast(p2.data);
            p2 = p2.next;
        }
        
        while(p1 != null){
            res.addLast(p1.data);
            p1 = p1.next;
        }
        
        return res;
    }
}
