import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int i = 1;
         int first = 0 , second = 1;
         while(i <= n){
          int third = first + second;

          System.out.println(first);

          first = second;
          second = third;
          i++;
         }
    }
  }