import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        // logic 
        int i = 0 , j = 0 , dir = 0;
        int prevI = -1, prevJ = -1;
        
        while(i >= 0 && j >= 0 && i < nr && j < nc){
            dir = (dir+mat[i][j])%4;
            prevI = i;
            prevJ = j;
            
            if(dir == 0){
                j++;
            }else if(dir == 1){
                i++;
            }else if(dir == 2){
                j--;
            }else if(dir == 3){
                i--;
            }
        }
        
        System.out.println(prevI);
        System.out.println(prevJ);
    }

}