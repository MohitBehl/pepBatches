import java.util.*;
    
    public class digitsOfANumber{
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int num = scn.nextInt();
        
        // logic
        
        // 1. count of digits
        int temp = num;
        int count = 0;
        
        while(temp != 0){
            temp = temp / 10;
            count++;
        }
        
        int div = (int)Math.pow(10,count-1);
        
        while(div != 0){
            int digit = num / div;
            System.out.println(digit);
            
            // preparation for next iteration
            num = num % div;
            div = div / 10;
        }
     }
    }