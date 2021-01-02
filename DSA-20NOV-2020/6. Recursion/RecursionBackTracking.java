import java.lang.annotation.Target;
import java.util.Scanner;

public class RecursionBackTracking {
    public static void main(String[] args) {
        // floodFill();
        targetSumSubsets();
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
