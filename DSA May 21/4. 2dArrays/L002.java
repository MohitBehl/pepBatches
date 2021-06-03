import java.util.*;

public class L001 {
    public static void main(String[] args) {
        
    }
    public static void SearchInASorted2dArray(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int mat[][] = new int[n][n];

        for (int i = 0 ; i < n; i++) {
            for (int j = 0 ; j < n ; j++) {
            mat[i][j] = scn.nextInt();
            }
        }

        int ele = scn.nextInt();

        // logic

        int r = 0 , c = n - 1;
        int flag = 0;
        while(c >= 0 && r < n){
            if(mat[r][c] == ele){
                // element found
                System.out.println(r+"\n"+c);
                flag = 1;
                break;
            }else if(ele < mat[r][c]){
                c--;
            }else if(ele > mat[r][c]){
                r++;
            }
        }
        if(flag == 0){
            System.out.println("Not Found");
        }
    }
    public static void spiralDisplay(){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        int mat[][] = new int[nr][nc];
        
        for(int i = 0 ; i < nr; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        // logic
        
        int rmin = 0, cmin = 0, rmax = nr-1,cmax = nc-1; 
        int count = 0 , tEle = nr*nc;
        while(count < tEle){
            // leftWall
            for(int r = rmin , c = cmin ; r <= rmax && count < tEle; r++){
                System.out.println(mat[r][c]);
                count++;
            }
            
            // BottomWall
            for(int r = rmax , c = cmin+1 ; c <= cmax && count < tEle; c++){
                System.out.println(mat[r][c]);
                count++;
            }
            
            // RightWall
            for(int r = rmax-1 , c = cmax ; r >= rmin && count < tEle; r--){
                System.out.println(mat[r][c]);
                count++;
            }
            
            // TopWall
            for(int r = rmin , c = cmax-1 ; c >= cmin+1 && count < tEle; c--){
                System.out.println(mat[r][c]);
                count++;
            }
            
            rmin++;
            cmin++;
            rmax--;
            cmax--;
        }
    }
    public static void diagonalTraversal(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int mat[][] = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        // logic 
        
        for(int i = 0 , j = 0 ; j < n ; j++){
            for(int r = i , c = j ; c < n ; r++,c++){
                System.out.println(mat[r][c]);
            }
        }
    }
    
}
