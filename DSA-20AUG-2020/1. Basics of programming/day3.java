// ---------------------------------------------------------------
// QUESTION : Prime Factorisation --------------------------------
import java.util.*;

public class Main{

public static void main(String[] args) {
  // write your code here  
    Scanner scn = new Scanner(System.in);
    int num = scn.nextInt();
    
    
    
    for(int fac = 2 ; fac*fac <= num ;fac++){
        while(num % fac == 0){
            System.out.print(fac+" ");
            num /= fac;
        }
    }
    
    if(num != 1){
        System.out.println(num);
    }
 }
}

// ---------------------------------------------------------------
// QUESTION : GCD & LCM ------------------------------------------
import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn = new Scanner(System.in);
      int num1 = scn.nextInt();
      int num2 = scn.nextInt();
      
      int tn1 = num1;
      int tn2 = num2;
      
      // gcd & lcm ----> code here
      
      
      while(tn1 % tn2 != 0){
          // rem
          int rem = tn1 % tn2;
          tn1 = tn2;
          tn2 = rem;
      }
      
      int gcd = tn2;
      int lcm = (num1 * num2)/gcd;
      
      System.out.println(gcd);
      System.out.println(lcm);
      
     }
}

// ---------------------------------------------------------------
// QUESTION : Benjamin Bulbs -------------------------------------
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
    
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        
        for(int i = 1 ; i * i <= num ; i++){
            System.out.print(i*i +" ");
        }
   }
}

// ---------------------------------------------------------------
// QUESTION : Rotate a number ------------------------------------
import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here  
     Scanner scn = new Scanner(System.in);
     
     int num = scn.nextInt();
     int k = scn.nextInt();
     
     
     //1. number of digits 
     int temp = num;
     int count = 0;
     while(temp != 0){
         count++;
         temp /= 10;
     }
     
     
     //2. true rotations 
     k = k%count;
     
     // handle negative rotations
     if(k < 0) k = k+count;
     
     int div = 1,mul = 1;
     
     for(int i = 1 ; i <= count ;i++){
         if(i <= k){
             div = div * 10;
         }else{
             mul = mul * 10;
         }
     }
     
     //3. divide the number in two parts --> div factor
     
     int p1 = num / div;
     int p2 = num % div;
     
     //4. rearrange --> mul factor
     
     int ans = (p2 * mul) + p1;
     System.out.println(ans);
    }
}