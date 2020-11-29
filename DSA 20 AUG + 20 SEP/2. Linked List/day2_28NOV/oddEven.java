public class oddEven {
    public void oddEven(){
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();
        
        while(size != 0){
            int val = getFirst();
            removeFirst(); // removal from main list
            
            if(val%2 == 0){
              //   even
              even.addLast(val);
            }else{
              //   odd
              odd.addLast(val);
            }
        }
        
        if(odd.size() == 0){
            // all elements are even
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size();
        }else if(even.size() == 0){
            // all elements are odd
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size();
        }else{
            this.head = odd.head;
            this.tail = even.tail;
            odd.tail.next = even.head;
            this.size = odd.size() + even.size();
        }
      }
}
