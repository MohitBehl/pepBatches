public class displayReverse {
    private void displayReverseHelper(Node node){
        if(node == null){
            return;
        }
      displayReverseHelper(node.next);
      
      System.out.print(node.data+" ");
    }

    public void displayReverse(){
      displayReverseHelper(head);
      System.out.println();
    }
}
