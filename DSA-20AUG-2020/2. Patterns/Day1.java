// ---------------------------------------------------------------
// QUESTION : Pattern 1 ------------------------------------------
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
            
        
        
        for(int row = 1 ; row <= n ; row++){
            // will work for n rows
            
            // code for each row
            for(int col = 1 ; col <= row ; col++){
                System.out.print("*\t");
            }
            
            // move to nextLine
            System.out.println();
        }

    }
}

// ---------------------------------------------------------------
// QUESTION : Pattern 2 ------------------------------------------
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // IMPLEMENTATION - 1
        int n = scn.nextInt();
        
        int nrow = n;
        
        int row = 1;
        
        int nstar = n;
        
        while(row <= nrow){
            
            // work for one row --> print nstars
            for(int i = 1 ; i<= nstar ; i++){
                System.out.print("*	");
            }
            
            // next line
            
            System.out.println();
            
            // preparation for next row
            
            nstar--;
            row++;
        }

        // IMPLEMENTATION - 2
        // for(int row = 1 ; row<= n ; row++){
            
        //     for(int col = row ; col <= n ; col++){
        //         System.out.print("*	");
        //     }
            
        //     System.out.println();
        // }
    }
}

// ---------------------------------------------------------------
// QUESTION : Pattern 3 ------------------------------------------
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        
        int n = scn.nextInt();
        
        int nrow = n;
        int nspace = n-1;
        int nstar = 1;
        int row = 1;
        
        while(row <= nrow){
            // code --> spaces + stars
            for(int i = 1 ; i <= nspace ; i++) System.out.print("	");
            
            for(int i = 1 ; i <= nstar ; i++) System.out.print("*" + "	");
            
            // nextLine
            System.out.println();
            // preparation for next row
            
            row++;
            nspace--;
            nstar++;
        }
    }
}

// ---------------------------------------------------------------
// QUESTION : Pattern 5 ------------------------------------------
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        
        int n = scn.nextInt();
        
        int nrow = n;
        int row = 1;
        int nspaces = n/2;
        int nstars = 1;
        
        while(row <= nrow){
            
            // code for each line 
            //  1. print spaces
            for(int i = 1 ; i <= nspaces ; i++){
                System.out.print("	");
            }
            // 2. print stars
            for(int i = 1 ; i <= nstars ; i++){
                System.out.print("*	");
            }
            
            // next line 
            System.out.println();
            
            // preparation for next line 
            
            if(row <= n/2){
                nspaces--;
                nstars += 2;
            }else{
                nspaces++;
                nstars -= 2;
            }
            
            row++;
        }

    }
}

// ---------------------------------------------------------------
// QUESTION : Pattern 7 ------------------------------------------

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        for(int row = 1 ; row <= n ; row++){
            for(int col = 1 ; col <= n ; col++){
                if((row == col))
                 System.out.print("*	");
                else
                 System.out.print("	");
            }
            System.out.println();
        }


    }
}

// ---------------------------------------------------------------
// QUESTION : Pattern 8 ------------------------------------------

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        for(int row = 1 ; row <= n ; row++){
            for(int col = 1 ; col <= n ; col++){
                if((row + col == n+1))
                 System.out.print("*	");
                else
                 System.out.print("	");
            }
            System.out.println();
        }


    }
}

// ---------------------------------------------------------------
// QUESTION : Pattern 9 ------------------------------------------

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        
        int n = scn.nextInt();
        
        for(int row = 1 ; row <= n ; row++){
            for(int col = 1 ; col <= n ; col++){
                if((row == col) || (row + col == n+1))
                 System.out.print("*	");
                else
                 System.out.print("	");
            }
            System.out.println();
        }

    }
}

// ---------------------------------------------------------------
// QUESTION : Pattern 11 -----------------------------------------

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        
        int n = scn.nextInt(); // input
        int val = 1;
        for(int r = 1; r<=n ;r++){
            for(int c = 1 ; c <= r ; c++){
                System.out.print(val+"\t");
                val++;
            }
            System.out.println();
        }

    }
}

// ---------------------------------------------------------------
// QUESTION : Pattern 12 -----------------------------------------
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        
        int n = scn.nextInt();
        
        int f = 0 , s = 1 , third = f + s;
        for(int r = 1 ; r <= n ; r++){
            for(int c = 1 ; c <= r ; c++){
                
                System.out.print(f+"\t");
                
                third = f + s;
                f = s;
                s = third;
            }
            System.out.println();
        }

    }
}

// ---------------------------------------------------------------