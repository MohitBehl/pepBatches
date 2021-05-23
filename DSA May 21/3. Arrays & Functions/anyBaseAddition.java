import java.util.*;
  
  public class anyBaseAddition{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       int res = 0 , carry = 0 , mul = 1;
       
       while(n1 != 0 || n2 != 0 || carry != 0){
           int d1 = n1 % 10;
           int d2 = n2 % 10;
           
           int sum = d1 + d2 + carry;
           int digit = sum % b;
           carry = sum / b;
           
           res = res + (digit * mul);
           
           n1 = n1 / 10;
           n2 = n2 / 10;
           mul = mul * 10;
       }
       
       return res;
   }
  }