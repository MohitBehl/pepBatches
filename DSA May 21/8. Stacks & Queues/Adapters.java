public class Adapters {
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
          if(this.size() == 0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              while(mainQ.size() > 1){
                  helperQ.add(mainQ.remove());
              }
              
              int tme = mainQ.remove();
              
              Queue<Integer> tempQ = mainQ;
              mainQ = helperQ;
              helperQ = tempQ;
              
              return tme;
          }
        }
    
        int top() {
          if(this.size() == 0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              
              while(mainQ.size() > 1){
                  helperQ.add(mainQ.remove());
              }
              
              int tme = mainQ.remove();
              helperQ.add(tme);
              
              Queue<Integer> tempQ = mainQ;
              mainQ = helperQ;
              helperQ = tempQ;
              
              return tme;
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
          
          Queue<Integer> tmpQ = mainQ;
          mainQ = helperQ;
          helperQ = tmpQ;
        }
    
        int pop() {
          if(this.size() == 0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              return mainQ.remove();
          }
        }
    
        int top() {
          if(this.size() == 0){
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
          if(this.size() == 0){
              System.out.println("Queue underflow");
              return -1;
          }else{
              while(mainS.size() > 1){
                  helperS.push(mainS.pop());
              }
              int fe = mainS.pop();
              while(helperS.size() > 0){
                  mainS.push(helperS.pop());
              }
              return fe;
          }
        }
    
        int peek() {
          if(this.size() == 0){
              System.out.println("Queue underflow");
              return -1;
          }else{
              while(mainS.size() > 1){
                  helperS.push(mainS.pop());
              }
              int fe = mainS.peek();
              while(helperS.size() > 0){
                  mainS.push(helperS.pop());
              }
              return fe;
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
            while(mainS.size() > 0 ){
                helperS.push(mainS.pop());
            } 
            mainS.push(val);
            while(helperS.size() > 0){
                mainS.push(helperS.pop());
            }
        }
    
        int remove() {
          if(this.size() == 0){
              System.out.println("Queue underflow");
              return -1;
          }else{
              return mainS.pop();
          }
        }
    
        int peek() {
          if(this.size() == 0){
              System.out.println("Queue underflow");
              return -1;
          }else{
              return mainS.peek();
          }
        }
      }

      public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;
    
        public TwoStack(int cap) {
          data = new int[cap];
          tos1 = -1;
          tos2 = cap;
        }
    
        int size1() {
          return tos1+1;
        }
    
        int size2() {
          return data.length-tos2;
        }
    
        void push1(int val) {
          if(this.size1() + this.size2() == data.length){
              System.out.println("Stack overflow");
              return;
          }else{
              tos1++;
              data[tos1] = val;
          }
        }
    
        void push2(int val) {
          if(this.size1() + this.size2() == data.length){
              System.out.println("Stack overflow");
              return;
          }else{
              tos2--;
              data[tos2] = val;
          }
        }
    
        int pop1() {
          if(this.size1() == 0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              int val = data[tos1];
              data[tos1] = 0;
              tos1--;
              return val;
          }
        }
    
        int pop2() {
          if(this.size2() == 0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              int val = data[tos2];
              data[tos2] = 0;
              tos2++;
              return val;
          }
        }
    
        int top1() {
          if(this.size1() == 0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              int val = data[tos1];
              return val;
          }
        }
    
        int top2() {
          if(this.size2() == 0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              int val = data[tos2];
              return val;
          }
        }
      }
}
