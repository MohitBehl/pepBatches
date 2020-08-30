// ---------------------------------------------------------------
// QUESTION : Pythagorean Triplet---------------------------------
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner scn = new Scanner(System.in);
    int s1 = scn.nextInt();
    int s2 = scn.nextInt();
    int s3 = scn.nextInt();
    
    boolean exp1 = ((s2*s2) + (s3*s3) == (s1*s1));
    boolean exp2 = ((s1*s1) + (s3*s3) == (s2*s2));
    boolean exp3 = ((s1*s1) + (s2*s2) == (s3*s3));
    boolean ans = exp1 || exp2 || exp3;
    System.out.println(ans);
   }
  }

// ---------------------------------------------------------------
// QUESTION : Fibonacci till n -----------------------------------

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      // write your code here
      
      Scanner scn = new Scanner(System.in);
      
      int n = scn.nextInt();
      
      int f = 0;
      int s = 1;
      if(n >= 1){
          System.out.print(f+"\n");
      }
      
      if(n >= 2){
          System.out.print(s+"\n");
      }
      
      for(int i = 3 ; i <= n ;i++){
          int t = f + s;
          System.out.print(t+"\n");
          
          f = s;
          s = t;
      }
   }
  }

// ---------------------------------------------------------------
// QUESTION : Is number prime ------------------------------------
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       
       int t = scn.nextInt();
       
       for(int i = 0 ; i < t ;i++){
           int num = scn.nextInt();
           
           // check for prime
           boolean isPrime = true;
           for(int div = 2 ; div*div <= num ; div++){
               if(num%div == 0){
                   // factor of num is div
                   // number is not-prime
                   isPrime = false;
                   break;
               }
           }
           
           if(isPrime == false){
               // number is not prime , factors are more than two
               System.out.println("not prime");
           }else{
               // number is prime
               System.out.println("prime");
           }
           
       }
  
   }
  }

// ---------------------------------------------------------------
// QUESTION : Count Digits ---------------------------------------
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int count = 0;
        // main logic 
        // Intuition : divide num by 10 , increase the count till number becomes 0

        while (num != 0) {
            num /= 10;
            count++;
        }

        System.out.println(count);

    }
}

// ---------------------------------------------------------------
// QUESTION : Reverse a number -----------------------------------
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        while (num != 0) {
            int digit = num % 10;

            System.out.println(digit);

            num /= 10;
        }


    }
}

// ---------------------------------------------------------------
// QUESTION : Inverse of a number --------------------------------
import java.util.*;

public class Main{

public static void main(String[] args) {
  // write your code here  
  Scanner scn = new Scanner(System.in);
  
    int num = scn.nextInt();
  
    int idx = 1;
    
    int inverse = 0;
    
    while(num != 0){
        int pv = num % 10; // place-value
        
        inverse += (idx * Math.pow(10,pv-1));
        
        idx++;
        num /= 10;
    }
    
    System.out.println(inverse);
 }
}

// ---------------------------------------------------------------