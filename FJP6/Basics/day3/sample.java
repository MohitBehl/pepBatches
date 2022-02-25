import java.util.*;
    
    public class sample{
    
    public static void main(String[] args) {
      // write your code here 
    // System.out.println("Hello World);
		// System.out.println("enter any number");
 		  Scanner scn=new Scanner(System.in);
 		    int num=scn.nextInt();
        int ne=num;
        int i=0;
        while(ne>0){
            System.out.println("in");
            ne=ne/10;
            i++;
        }
        int j=i-1;//why this line is written
        int div=(int)Math.pow(10,j); //directly i-1 kyo nhi,kyonki (int,int)format hota hai i-1 is not int
        int n=num;
        while(div>0)// n>0 will not work in few cases eg 1000
        {
            int fst=n/div;
            System.out.println(fst);
            div=div/10;
            n=n%div;
        } 
     }
    }
