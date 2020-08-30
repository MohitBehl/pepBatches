// ---------------------------------------------------------------
// QUESTION : print z in java-------------------------------------
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // Write your code here
        // method 1
        System.out.println("*****");
        System.out.println("   *");
        System.out.println("  *");
        System.out.println(" *");
        System.out.println("*****");
        
        // method 2
        // System.out.print("*****");
        // System.out.print("   *");
        // System.out.print("  *");
        // System.out.print(" *");
        // System.out.print("*****");
        
        // method 3
        // System.out.print("*****\n   *\n  *\n *\n*****");
    }
}
// ---------------------------------------------------------------

// ---------------------------------------------------------------
// QUESTION : Grading System -------------------------------------
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      // input - don't change this code
      Scanner scn = new Scanner(System.in);
      int marks = scn.nextInt();
      // input - don't change this code   
        
      // IMPLEMENTATION : 1 
    //   if(marks > 90){
    //       // marks > 90
    //       System.out.println("excellent");
    //   }else if(marks > 80){
    //       // marks > 80 & marks <= 90
    //       System.out.println("good");
    //   }else if(marks > 70){
    //       // marks > 70 & marks <= 80
    //       System.out.println("fair");
    //   }else if (marks > 60){
    //     //  marks > 60 & marks <= 70
    //       System.out.println("meets expectations");
    //   }else {
    //     //   marks <= 60
    //       System.out.println("below par");
    //   }
      
      // IMPLEMENTATION : 2
      if(marks > 90){
          System.out.println("excellent");
      }else if(marks > 80 && marks <= 90){
          System.out.println("good");
      }else if(marks > 70 && marks <= 80){
          System.out.println("fair");
      }else if(marks > 60 && marks <= 70){
          System.out.println("meets expectations");
      }else {
          System.out.println("below par");
      }
   }
    
  }
// ---------------------------------------------------------------