//problem name : Problematic Palindrome
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        int tmp = num;
        int revNum = 0;

        // find reverse of number 
        while(tmp != 0){
            int digit = tmp % 10;
            tmp /= 10;
            revNum = (revNum*10)+digit;
        }

        System.out.println(num == revNum);
    }
}

// problem name : PYRAMID$%
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int nsp = n-1 , nst = 1;
        
        for(int row = 1 ; row <= n ; row++){
            
            // print spaces
            for(int i = 1 ; i <= nsp ; i++){
                System.out.print("\t");
            }

            // print stars
            int tmp = row;
            for(int i = 1 ; i <= nst ; i++){
                System.out.print(tmp+"\t");
                if(i <= nst/2){
                    tmp++;
                }else{
                    tmp--;
                }
            }

            //newline 
            System.out.println();

            nsp--;
            nst += 2;
        }
    }
}

//problem name : welcome_Rangoli
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nrows = scn.nextInt();
        int ncols = scn.nextInt();

        int row = 1 , nUnderScores = (ncols-3)/2 , nPattern = 1;

        while(row <= nrows){
            for(int i = 1 ; i <= nUnderScores ; i++){
                System.out.print("-");
            }

            if(row == nrows/2+1){
                    printWelcome(ncols);
            }else{
                for(int i = 1 ; i <= nPattern ; i++){
                        System.out.print(".|.");
                }
            }

            for(int i = 1 ; i <= nUnderScores ; i++){
                System.out.print("-");
            }

            System.out.println();

            if(row <= nrows/2){
                nUnderScores -= 3;
                nPattern += 2;
            }else{
                nUnderScores += 3;
                nPattern -= 2;
            }

            row++;
        }
    }
    public static void printWelcome(int cols){
        for(int i = 1; i <= (cols-7)/2 ; i++){
            System.out.print("-");
        }
        System.out.print("WELCOME");
        for(int i = 1; i <= (cols-7)/2 ; i++){
            System.out.print("-");
        }
    }
}

//problem name : webkull_pattern1
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i = 1 ; i <= n ; i++) {System.out.print("@");}
        System.out.println();

        int nst = 1;
        for(int r = 1 ; r <= n ; r++){
            // n-1 spaces
            for(int i = 1 ; i < n ; i++){System.out.print(" ");}

            // nst stars
            for(int i = 1 ; i <= nst ; i++){System.out.print("*");}
            
            System.out.println();
            // if(i <= n/2){
            //     nst++;
            // }else{
            //     nst--;
            // }
            nst = (r <= n/2) ? nst+1 : nst-1;
        }
        for(int i = 1 ; i < n-1 ; i++) {System.out.print(" ");}
        for(int i = 1 ; i <= n ; i++) {System.out.print("@");}
    }
}

// problem name : circle maniac
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        
        int x1 = scn.nextInt() , y1 = scn.nextInt(); // centre of circle 1
        int x2 = scn.nextInt() , y2 = scn.nextInt(); // centre of circle 2
        int r1 = scn.nextInt(); // radius of circle 1
        int r2 = scn.nextInt(); // radius of circle 2

        double dist = Math.sqrt(((x2-x1) * (x2-x1)) + ((y2 - y1)*(y2 - y1)));

        if(dist == 0 && r1 != r2){
            System.out.println("concentric");
        }else if(dist <= Math.abs(r1-r2)){
            System.out.println("overlaps");
        }else if(dist == r1+r2){
            System.out.println("touches at 1 point");
        }else if(dist < r1+r2){
            System.out.println("touches at 2 point");
        }else if(dist > r1+r2){
            System.out.println("far-apart");
        }
    }
}