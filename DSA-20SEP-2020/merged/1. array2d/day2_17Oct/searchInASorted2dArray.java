import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int mat[][] = new int[n][n];
        
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        int ele = scn.nextInt();
        
        int r = 0 , c = n-1;
        
        while(r < n && c >= 0){
            
            if(mat[r][c] == ele){
                // element found
                System.out.println(r);
                System.out.println(c);
                return;
            }else if(ele < mat[r][c]){
                // smaller
                c--;
            }else{
                // larger
                r++;
            }
        }
        
        System.out.println("Not Found");
    }

}