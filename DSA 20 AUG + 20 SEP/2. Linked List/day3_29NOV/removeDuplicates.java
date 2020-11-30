/**
 * removeDuplicates
 */
public class removeDuplicates {

    public static Node removeDuplicates(Node head) {
        Node traversal = head;
        
        while(traversal != null){
            Node run = traversal;
            
            while(run != null && run.data == traversal.data){
                run = run.next;
            }
            
            traversal.next = run;
            
            traversal = traversal.next;
        }
        
        return head;
    }
}