import java.io.*;
import java.util.*;

public class Main {

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
      // move elements from mainQ -> helperQ
      while(mainQ.size() > 0){
          int ele = mainQ.remove();
          helperQ.add(ele);
      }
      
      // add val to mainQ
      mainQ.add(val);
      
      // move elements from helperQ -> mainQ
      while(helperQ.size() > 0){
          int ele = helperQ.remove();
          mainQ.add(ele);
      }
    }

    int pop() {
      if(mainQ.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      
      return mainQ.remove();
    }

    int top() {
      if(mainQ.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      
      return mainQ.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}