
import java.util.*;

public class primeFactorization{

public static void main(String[] args) {
  Scanner scn = new Scanner(System.in);
  int n = scn.nextInt();
  
  // logic 
  
  for(int fac = 2 ; fac*fac <= n ; fac++){
      while(n%fac==0){
          n = n/fac;
          System.out.print(fac+" ");
      }
  }
  
  if(n != 1){
      System.out.println(n);
  }
 }
}