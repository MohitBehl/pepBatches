import java.util.*;

public class pattern19{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    
    for(int r = 1; r <= n ; r++){
        for(int c = 1; c <= n ; c++){
            if(r == 1){
                if(c == n || c <= (n/2)+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }else if(r > 1 && r <= n/2){
                if(c == n || c == (n/2)+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }else if(r == (n/2)+1){
                System.out.print("*\t");
            }else if(r > (n/2)+1 && r < n){
                if(c == 1 || c == (n/2)+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }else if(r == n){
                if(c == 1 || c >= (n/2)+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
        }
        System.out.println();
    }

 }
}