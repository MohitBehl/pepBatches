
import java.util.*;
  
  public class curiousCase{
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    
    // logic
    
    for(int fac = 1 ; fac * fac <= n ; fac++){
        System.out.println(fac*fac);
    }
   }
  }