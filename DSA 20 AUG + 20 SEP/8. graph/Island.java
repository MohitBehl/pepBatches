import java.util.Scanner;

public class Island {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt() , nc = scn.nextInt();
        int board[][] = new int[nr][nc];

        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                board[i][j] = scn.nextInt();
            }
        }

        System.out.println(numberOfIslands(board));
    }

    public static int numberOfIslands(int [][]board){
        boolean[][] visited = new boolean[board.length][board[0].length];
        int count = 0 ;
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 0 && visited[i][j] == false){
                    floodFill(board, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public static void floodFill(int[][] board,int i , int j , boolean[][] visited){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] == 1){
            // invalid pos/ already discovered area/ not land i.e. water 
            return;
        }
        visited[i][j] = true;
        floodFill(board, i-1, j, visited);// north
        floodFill(board, i, j+1, visited);// east 
        floodFill(board, i, j-1, visited);// west
        floodFill(board, i+1, j, visited);// south
    }
}
