import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
      int t = scn.nextInt();
     
      for(int j = 1 ; j <= t ; j++){
        int num = scn.nextInt();

        int flag = 1; // 1 -> prime
        for(int i = 2 ; i*i <= num ; i++){
            if(num % i == 0){
                // number is not prime
                flag = 0; // 0 -> not prime
                break;
            }
        }

        if(flag == 1){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }
      }
       
   }
  }