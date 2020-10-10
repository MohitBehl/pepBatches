import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       
       int mult = 1;
       int ans = 0;
       while(n != 0){
           int rem = n % b;
           
           ans = ans + (rem*mult);
           
           n = n / b;
           mult = mult * 10;
       }
       
       return ans;
   }
  }