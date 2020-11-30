/**
 * intersectionOfLinkedList
 */
public class intersectionOfLinkedList {

    public static int findIntersection(LinkedList one, LinkedList two){
        
        Node ptr1 = one.head;
        Node ptr2 = two.head;
        
        int diff = Math.abs(one.size() - two.size());
        
        if(one.size() < two.size()){
            // move second ptr
            for(int i = 1 ; i <= diff ; i++){
                ptr2 = ptr2.next;
            }
        }else if(one.size() > two.size()){
            // move first ptr
            for(int i = 1 ; i <= diff ; i++){
                ptr1 = ptr1.next;
            }
        }
        
        // ptr1 & ptr2 are equi-distant from intersection
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        // implication : ptr1 & ptr2 are currently pointing to intersection
        return ptr1.data;
    }
}