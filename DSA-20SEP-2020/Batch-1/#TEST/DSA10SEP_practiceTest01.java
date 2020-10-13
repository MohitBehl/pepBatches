// problem name : diamondProblem --------------------------------------------
import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int row = 1 , nsp = n/2 , nst = 1 , sp = 1;

        while(row <= n){
            for(int i = 1 ; i <= nsp ; i++){
                System.out.print("\t");
            }
            
            int tmp = sp;
            for(int i = 1 ; i <= nst ; i++){
                System.out.print(tmp+"\t");
                tmp = (i <= nst/2) ? tmp+1 : tmp-1;
            }

            System.out.println();

            if(row <= n/2){
                nsp--;
                nst += 2;
                sp++;
            }else{
                nsp++;
                nst-=2;
                sp--;
            }

            row++;
        }
    }
}

// problem name : hourGlass 6  ---------------------------------------------
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int row = 1, nsp = 0, nst = n;
        while(row <= n){
            for(int i = 1 ; i <= nsp ; i++){
                System.out.print("\t");
            }

            for(int i = 1 ; i <= nst ; i++){
                if(row > 1 && row <= n/2){
                    if(i != 1 && i != nst){
                        System.out.print("\t");
                        continue;
                    }
                }
                System.out.print("*\t");
            }

            System.out.println();

            if(row <= n/2){
                nsp++;
                nst -= 2;
            }else{
                nsp--;
                nst += 2;
            }
            row++;
        }
    }
}

//problem name : cool pattern 1 ----------------------------------------------
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int r = 1 ; r <= n ; r++){
            for(int c = 1 ; c <= n ; c++){
                if(r == 1){
                    if(c <= (n/2)+1 || c == n)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }else if(r > 1 && r <= n/2){
                    if(c == (n/2)+1 || c == n)
                        System.out.print("*\t");
                    else   
                        System.out.print("\t");
                }else if(r == (n/2)+1){
                    System.out.print("*\t");
                }else if(r > (n/2)+1 && r < n){
                    if(c == 1 || c == (n/2)+1)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }else{
                    if(c == 1 || c >= (n/2)+1)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}

// problem name :  MAD_ANGLES -------------------------------------------------
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int t1nst = 2*n-1 ,nsp = 0, t2nst = 1 , t3nst = 2*n-1 , row = 1;
        
        while(row <= n){
            for(int i = 1 ; i <= n ;i++){ System.out.print("*"); } // square 1
            
            System.out.print("  "); // seperator
            
            for(int i = 1 ; i <= nsp ; i++){ System.out.print(" "); } // space before triangle 1
            
            for(int i = 1 ; i <= t1nst ;i++){ System.out.print("*"); } // triangle 1
            
            System.out.print("  "); // seperator
            
            for(int i = 1 ; i <= t2nst ;i++){ System.out.print("*"); } // triangle 2
            
            System.out.print("  "); // seperator
            
            for(int i = 1 ; i <= t3nst ;i++){ System.out.print("*"); } // triangle 3
            
            for(int i = 1 ; i <= nsp ; i++){ System.out.print(" "); } // space after triangle 3
            
            System.out.print("  "); // seperator
            
            for(int i = 1 ; i <= n ;i++){ System.out.print("*"); } // square 2
            
            System.out.print("  "); // seperator
                        
            System.out.println(); // newline

            // preparation
            t1nst -= 2;
            t2nst += 2;
            t3nst -= 2;
            nsp++;
            row++;
        }
    }
}

// problem name : point of parity ---------------------------------------------
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(pointOfParity(arr));
    }

    public static int pointOfParity(int arr[]){
        if(arr.length < 3) return -1; // point of parity can't be possibly found 

        // find sum of elements from 1 index till end
        int sum = 0;
        for(int i = 1 ; i < arr.length ; i++){
            sum += arr[i];
        }

        int ssf = arr[0];

        for(int i = 1 ; i < arr.length ; i++){
            if(ssf == sum-arr[i]){
                return i;
            }

            ssf += arr[i];
            sum -= arr[i];
        }

        return -1;
    }
}

// problem name : linear check -------------------------------------------- 
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int x1 = scn.nextInt();
        int y1 = scn.nextInt();
        boolean isHorizontal = true , isVertical = true;
        
        for(int i = 2 ; i <= n ; i++){
            int tmpx = scn.nextInt();
            int tmpy = scn.nextInt();

            if(x1 != tmpx){
                isHorizontal = false;
            }

            if(y1 !=  tmpy){
                isVertical = false;
            }
        }

        if((isHorizontal && !isVertical) || (!isHorizontal && isVertical)){
            System.out.print("YES");            
        }else{
            System.out.print("NO");
        }
    }
}