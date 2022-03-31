import java.util.*;

public class Main{

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    for(int fac = 2; fac * fac <= n ; fac++){
      while(n%fac == 0){
        System.out.print(fac+" ");
        n = n / fac;
      }
    }

    if(n != 1){
      System.out.println(n);
    }  
  }
}