import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     int n = scn.nextInt();
     
     for(int row = 1 ; row <= n ; row++){
         for(int col = 1 ; col <= n ; col++){
             boolean print = false;
             
             if(row == 1){
                if((col >= 1 && col <= (n/2) + 1 ) || col == n){
                   print = true; 
                }
             }else if(row > 1 && row < (n/2) + 1 ){
                 if(col == (n/2) + 1 || col == n){
                    print = true;     
                 }
             }else if(row == (n/2) + 1){
                 print = true;
             }else if(row > (n/2) + 1 && row < n){
                 if(col == 1 || col == (n/2) + 1){
                    print = true;
                 }
             }else if(row == n){
                 if(col == 1 || (col >= (n/2) + 1 && col <= n)){
                    print = true;
                 }
             }
             
             if(print){
                 System.out.print("*\t");
             }else{
                 System.out.print("\t");
             }
         }
         
         System.out.println();
     }

 }
}