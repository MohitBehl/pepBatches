import java.util.*;

public class Main{

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    int ans = 0;
    int pos = 1;
    while(n != 0){
      int digit = n % 10;
      ans += (pos*Math.pow(10,digit-1));

      n = n / 10;
      pos++;
    }
    
    System.out.println(ans);
  }
}