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
       int mul = 1 ; // 10 to the power 0
       int ans = 0;
       while(n != 0){
           int rem = n % b;
           
           ans = ans + (rem * mul);
           
           n = n / b;
           mul = mul * 10;
       }
       
       return ans;
   }
  }