import java.io.*;
import java.util.*;

public class paintHouse{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int mat[][] = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            mat[i][0] = scn.nextInt();
            mat[i][1] = scn.nextInt();
            mat[i][2] = scn.nextInt();
        }
        
        // logic
        
        int costRed = 0, costBlue = 0, costGreen = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                costRed = mat[0][0];
                costBlue = mat[0][1];
                costGreen = mat[0][2];
            }else{
                int red = Math.min(costBlue,costGreen) + mat[i][0];
                int blue = Math.min(costRed,costGreen) + mat[i][1];
                int green = Math.min(costRed,costBlue) + mat[i][2];
                
                costRed = red;
                costBlue = blue;
                costGreen = green;
            }
        }
        
        int cost =  Math.min(costRed,Math.min(costBlue,costGreen));
        
        System.out.println(cost);
    }
}