public class reverseLinkedListDataIterative {
    private Node getNode(int idx){
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp;
    }
    public void reverseDI() {
        
        int lIdx = 0;
        int rIdx = size()-1;
        
        while(lIdx < rIdx){
            Node left = getNode(lIdx);
            Node right = getNode(rIdx);
            
            int tmp = left.data;
            left.data = right.data;
            right.data = tmp;
            
            lIdx++;
            rIdx--;
        }
    }
}
