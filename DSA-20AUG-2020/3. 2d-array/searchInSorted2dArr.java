
import java.util.*;

public class searchInSorted2dArr {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int mat[][] = new int[n][n];
        scn.close();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        int val = scn.nextInt();

        int r = 0  , c = mat[0].length-1;

        while(r < mat.length && c >= 0){
            if(val == mat[r][c]){
                // element found
                System.out.println(r);
                System.out.println(c);
                return;
            }else if(val > mat[r][c]){
                // search in larger elements
                r++;
            }else if(val < mat[r][c]){
                // search in smaller elements
                c--;
            }
        }
        System.out.println("Not Found");
        
    }

}