public class Adaptors {
    
}
public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      return mainQ.size();
    }

    void push(int val) {
      mainQ.add(val);
    }

    int pop() {
      if(size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }else{
          // move n-1 elements from mainQ -> helperQ
          while(mainQ.size() > 1){
              helperQ.add(mainQ.remove());
          }
          int val = mainQ.remove(); // last element of mainQ is topmost element of stack
          // swap references
          Queue<Integer> temp = mainQ;
          mainQ = helperQ;
          helperQ = temp;
          
          return val;
      }
    }

    int top() {
      if(size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }else{
          // move n-1 elements from mainQ -> helperQ
          while(mainQ.size() > 1){
              helperQ.add(mainQ.remove());
          }
          int val = mainQ.remove(); // last element of mainQ is topmost element of stack
          helperQ.add(val);
          // swap references
          Queue<Integer> temp = mainQ;
          mainQ = helperQ;
          helperQ = temp;
          
          return val;
      }
    }
  }

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      return mainQ.size();
    }

    void push(int val) {
      helperQ.add(val);
      
      while(mainQ.size() > 0){
          helperQ.add(mainQ.remove());
      }
      
      Queue<Integer> tempQ = mainQ;
      mainQ = helperQ;
      helperQ = tempQ;
    }

    int pop() {
      if(size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }else{
          return mainQ.remove();
      }
    }

    int top() {
      if(size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }else{
          return mainQ.peek();
      }
    }
  }

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      return mainS.size();
    }

    void add(int val) {
      mainS.push(val);
    }

    int remove() {
        if(size() == 0){
          System.out.println("Queue underflow");
          return -1;
        }else{
          while(mainS.size() > 0){
              helperS.push(mainS.pop());
          }
          int val = helperS.pop();
          while(helperS.size() > 0){
              mainS.push(helperS.pop());
          }
          
          return val;
        }
    }

    int peek() {
        if(size() == 0){
          System.out.println("Queue underflow");
          return -1;
        }else{
          while(mainS.size() > 0){
              helperS.push(mainS.pop());
          }
          int val = helperS.peek();
          while(helperS.size() > 0){
              mainS.push(helperS.pop());
          }
          
          return val;
        }
    }
  }

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      return mainS.size();
    }

    void add(int val) {
      while(mainS.size() > 0){
          helperS.push(mainS.pop());
      }
      
      mainS.push(val);
      
      while(helperS.size() > 0){
          mainS.push(helperS.pop());
      }
    }

    int remove() {
      if(size() == 0){
          System.out.println("Queue underflow");
          return -1;
      }else{
          return mainS.pop();
      }
    }

    int peek() {
      if(size() == 0){
          System.out.println("Queue underflow");
          return -1;
      }else{
          return mainS.peek();
      }
    }
  }