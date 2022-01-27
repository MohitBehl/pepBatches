import java.io.*;
import java.util.*;

public class NormalQueue {

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
      int n = data.length;
      for(int idx = 0 ; idx < this.size ; idx++){
          System.out.print(data[(this.front+idx) % n]+" ");
      }
      System.out.println();
    }

    void add(int val) {
      if(this.size == this.data.length){
          System.out.println("Queue overflow");
          return;
      }
      
      int idx = (this.front + this.size) % this.data.length;
      this.data[idx] = val;
      this.size++;
    }

    int remove() {
      if(this.size == 0){
           System.out.println("Queue underflow");
           return -1;
       }
       int val = data[front];
       front = (front+1)%this.data.length;
       size--;
       return val;
    }

    int peek() {
       if(this.size == 0){
           System.out.println("Queue underflow");
           return -1;
       }
       int val = data[front];
       return val;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("add")){
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if(str.startsWith("remove")){
        int val = qu.remove();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("peek")){
        int val = qu.peek();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}