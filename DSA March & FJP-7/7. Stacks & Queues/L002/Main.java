import java.util.*;

public class Main{
    public static void queueIntro(){
        // Queue<Integer> queue = new Queue<Integer>(); // error
        Queue<Integer> queue = new ArrayDeque<>();

        System.out.println(queue);
        queue.add(10);
        System.out.println(queue);
        queue.add(20);
        System.out.println(queue);
        queue.add(30);
        System.out.println(queue);

        System.out.println(queue.remove() +" status : "+queue);
        System.out.println(queue.peek() +" status : "+queue);

        System.out.println(queue.size());
    }
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
            for(int idx = 0 ; idx < size ; idx++){
                System.out.print(data[(front+idx) % data.length] +" ");
            }
            System.out.println();
        }    
        void add(int val) {
            if(size == data.length){
                // int[] ndata = new int[2 * data.length];

                // for(int i = 0; i < size; i++){
                // int idx = (front + i) % data.length;
                // ndata[i] = data[idx];
                // }

                // front = 0;

                // data = ndata;
                System.out.println("Queue overflow");
                return;
            }
            int idx = (front+size)%data.length;
            data[idx] = val;
            size++;
        }
        int remove() {
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            }
            int vl = data[front];
            front = (front + 1) % data.length;
            size--;
            return vl;
        }
        int peek() {
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            }
            int vl = data[front];
            return vl;
        }
      }
    public static void main(String args[]){
        
    }
}