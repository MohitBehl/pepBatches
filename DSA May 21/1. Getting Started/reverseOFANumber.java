import java.util.*;
   
   public class reverseOFANumber{
   
   public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);
     int num = scn.nextInt();
     
     // logic
     
     while(num != 0){
         int digit = num%10;
         System.out.println(digit);
         
         // preparation for next iteration
         num = num/10;
     }
    }
   }