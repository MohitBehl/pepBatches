public class kReverseLinkedList {
    public void kReverse(int k) {
        LinkedList prev = null;
        LinkedList curr = new LinkedList();
        
        while(size() > 0){
            
            if(k <= size()){
              //   k reverse possible
              int i = 1;
              while(i <= k){
                  int val = getFirst(); // main list
                  removeFirst(); // main list
                  curr.addFirst(val); // curr list
                  i++;
              }
            }else{
              //   k reverse not-possible  
              int i = 1;
              int limit = size(); 
              while(i <= limit){
                  int val = getFirst(); // main list
                  removeFirst(); // main list
                  curr.addLast(val); // curr list
                  i++;
              }
            }
            
            if(prev == null){
                prev = curr;
                curr = new LinkedList();
            }else{
              //   prev list --> curr list
              prev.tail.next = curr.head;
              prev.tail = curr.tail;
              
              // size
              prev.size += curr.size;
              curr = new LinkedList();
            }
        }
        
        this.head = prev.head;
        this.tail = prev.tail;
        this.size = prev.size;
      }
}
