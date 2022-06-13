public class Main{
    public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      return size;
    }

    void display() {
        for(int i = 0 ; i < size ; i++){
            System.out.print(data[(front+i)%data.length]+" ");
        }
        System.out.println();
    }

    void add(int val) {
        if(size == data.length){
            // // dynamic behaviour
            int arr[] = new int[2 * data.length];

            for(int i = 0 ; i < size ; i++){
              arr[i] = data[(front+i)%data.length];
            }

            front = 0; // starting point 
            this.data = arr; // address change 

            // System.out.println("Queue overflow");
            // return;
        }
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
    }

    int remove() {
        if(size == 0){
            System.out.println("Queue underflow");
            return -1;
        }

        int val = data[front];
        front = (front+1)%data.length;
        size--;
        return val;
    }

    int peek() {
       if(size == 0){
            System.out.println("Queue underflow");
            return -1;
        }

        int val = data[front];
        return val;
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
      mainQ.add(val);
    }

    int pop() {
      if(mainQ.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      while(mainQ.size() > 1){
        helperQ.add(mainQ.remove());
      }
      int val = mainQ.remove();
      Queue<Integer> tmpQ = mainQ;
      mainQ = helperQ;
      helperQ = tmpQ;

      return val;
    }
    int top() {
      if(mainQ.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      while(mainQ.size() > 1){
        helperQ.add(mainQ.remove());
      }
      int val = mainQ.remove();
      helperQ.add(val);
      Queue<Integer> tmpQ = mainQ;
      mainQ = helperQ;
      helperQ = tmpQ;

      return val;
    }
  }
}