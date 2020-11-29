public class midOfLL {
  int mid(){
   Node fast = head , slow = head;

     while(fast.next != null && fast.next.next != null){
         slow = slow.next;
         fast = fast.next.next;
     }
     return slow.data;
 }        
}
