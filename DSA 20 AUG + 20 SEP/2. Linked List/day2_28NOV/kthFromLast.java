public class Main {
    public int kthFromLast(int k){
      Node slow = head, fast = head;
      
        // create distance
        for(int i = 1 ; i <= k ; i++){
            fast = fast.next;
        }
        
        // main logic
        while(fast != tail){
            fast = fast.next;
            slow = slow.next;
        }
        
        // implication : slow is pointing at kth node from last
        return slow.data;
    }
}