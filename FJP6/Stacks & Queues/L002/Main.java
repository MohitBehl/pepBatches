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
        if(size == 0) return;
        for(int i = 0 ; i < size ; i++){
            System.out.print(data[(front+i)%data.length]+" ");
        }
        System.out.println();
    }

    void add(int val) {
        if(size == data.length){
            System.out.println("Queue overflow");
            return;
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
}