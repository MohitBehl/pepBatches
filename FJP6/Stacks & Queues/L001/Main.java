import java.util.*;
public class Main{

   public static void main(String args[]){
      Scanner scn = new Scanner(System.in);

      String exp = scn.nextLine();

      System.out.println(duplicateBrackets(exp));
   }

   public static boolean duplicateBrackets(String exp){
      Stack<Character> st = new Stack<>();

      for(int i = 0 ; i < exp.length() ; i++){
          char ch = exp.charAt(i);
          if(ch == ' '){continue;}
          else 
          if(ch == ')'){
              if(st.peek() == '('){
                  return true;
              }else{
                  while(st.peek() != '('){
                      st.pop();
                  }
                  st.pop(); // (
              }
          }else{
              st.push(ch);
          }
      }
      return false;
   }

public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      return tos+1;
    }

    void display() {
      for(int idx = tos ; idx >= 0 ; idx--){
          System.out.print(data[idx]+" ");
      }
      System.out.println();
    }

    void push(int val) {
      if(size() == data.length){
          System.out.println("Stack overflow");
      }else{
          tos++;
          data[tos] = val;
      }
    }

    int pop() {
      if(size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }else{
          int topele = data[tos];
          tos--;
          return topele;
      }
    }

    int top() { // peek
       if(size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }else{
          int topele = data[tos];
          return topele;
      }
    }
  }
}