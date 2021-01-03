import java.lang.annotation.Target;
import java.util.Scanner;

import javax.swing.border.Border;

public class RecursionBackTracking {
    public static void main(String[] args) {
        // floodFill();
        // targetSumSubsets();
        // nQueens();
        knightsTour();
    }
    public static void knightsTour(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();

        knightsTour(new int[n][n],i,j,1);
    }
    public static void display(int [][]board){
        for(int arr[] : board){
            for(int val : arr){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static void knightsTour(int board[][],int row,int col,int moveNumber){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 0){
            return;
        }

        if(moveNumber == board.length * board[0].length){
            board[row][col] = moveNumber;// mark
            display(board);
            System.out.println();
            board[row][col] = 0; // unmark        
        }
        
        
        board[row][col] = moveNumber;// mark 
        knightsTour(board,row-2,col+1,moveNumber+1);// dir1
        knightsTour(board,row-1,col+2,moveNumber+1);// dir2
        knightsTour(board,row+1,col+2,moveNumber+1);// dir3
        knightsTour(board,row+2,col+1,moveNumber+1);// dir4
        knightsTour(board,row+2,col-1,moveNumber+1);// dir5
        knightsTour(board,row+1,col-2,moveNumber+1);// dir6
        knightsTour(board,row-1,col-2,moveNumber+1);// dir7
        knightsTour(board,row-2,col-1,moveNumber+1);// dir8
        board[row][col] = 0;
    }
    public static void nQueens(){
        // main code
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        nQueens(new int[n][n],0,"");
    }
    public static void nQueens(int board[][],int row,String csf){
        if(row == board.length){
            System.out.println(csf+".");
            return;
        }
        for(int col = 0; col < board[0].length ; col++){
            if(isSafe(board,row,col)){
                board[row][col] = 1; // mark
                nQueens(board,row+1,csf+row+"-"+col+" ,");
                board[row][col] = 0; // unmark
            }
        }
    }

    public static boolean isSafe(int [][]board,int row,int col){
        // vertically up
        for(int i = row-1,j = col ; i >= 0 ; i--){
            if(board[i][j] == 1){
                // pos compromised
                return false;
            }
        }

        // left diagonal
        for(int i = row-1,j = col-1 ; i>=0 && j>=0 ; i--,j--){
            if(board[i][j] == 1){
                // pos compromised
                return false;
            }
        }

        // right diagonal
        for(int i = row-1,j = col+1 ; i >= 0 && j < board[0].length ; i-- , j++){
            if(board[i][j] == 1){
                // pos compromised
                return false;
            }
        }

        // postion confirmed & is safe
        return true;
    }
    public static void targetSumSubsets(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();

        targetSumSubsets(arr,0,"",0,target);
    }

    public static void targetSumSubsets(int arr[],int idx,String asf,int ssf,int target){
        if(idx == arr.length){
            if(ssf == target){
                System.out.println(asf+".");
            }
            return;
        }
        if(ssf > target){
            // since input has a postive values
            return; 
        }
        targetSumSubsets(arr,idx+1,asf+arr[idx]+", ",ssf+arr[idx],target);// inc
        targetSumSubsets(arr,idx+1,asf,ssf,target);// inc// not inc
    }

    public static void floodFill(){
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int board[][] = new int[nr][nc];

        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                board[i][j] = scn.nextInt();
            }
        }

        floodFill(board,0,0,"",new boolean[nr][nc]);
    }

    public static void floodFill(int board[][],int i,int j,String psf,boolean visited[][]){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 1 || visited[i][j]){
            // invalid pos/obstacle/already visited
            return;
        }

        if(i == board.length-1 && j == board[0].length-1){
            // dest reached
            System.out.println(psf); // print path so far
            return;
        }

        visited[i][j] = true;// visited mark
        floodFill(board,i-1,j,psf+"t",visited);// top
        floodFill(board,i,j-1,psf+"l",visited);// left
        floodFill(board,i+1,j,psf+"d",visited);// down
        floodFill(board,i,j+1,psf+"r",visited);// right
        visited[i][j] = false;// visited unmark
    }
}
