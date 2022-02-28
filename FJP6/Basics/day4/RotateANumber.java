import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);

     int num = scn.nextInt();

     int k = scn.nextInt();

      int count = 0;
      int tnum = num;

      while(tnum != 0){
        tnum = tnum / 10;
        count++;
      }

      // actual rotations
      k = k % count;

      if(k < 0){ // -ve rotation
        k = k + count;
      }

      int tmp1 = (int)Math.pow(10,k);

      int p1 = num % tmp1;
      int p2 = num / tmp1;

      int tmp2 = (int)Math.pow(10,count-k);

      int ans = (p1*tmp2) + p2;
      System.out.println(ans);
    }
   }