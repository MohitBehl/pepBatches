import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int num = scn.nextInt();
    int pos = 1;
    int sum = 0;
    while(num != 0){
      int digit = num % 10;

      int vl = pos * (int)Math.pow(10,digit-1);
      sum += vl;

      pos++;
      num = num / 10;
    }

    System.out.println(sum);
 }
}