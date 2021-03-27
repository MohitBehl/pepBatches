public class L002NumberOfIslands{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int board[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                board[i][j] = scn.nextInt();
            }
        }

        System.out.printn(numberOfIslands(board));
    }

    public static int numberOfIslands(int [][]board){
        int count = 0;
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 0){
                    numberOfIslands(board,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static int numberOfIslands(int board[][] , int r , int c){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 1 || board[r][c] == 2){
            return;
        }
        board[r][c] = 2;
        numberOfIslands(board,r-1,c);// north
        numberOfIslands(board,r,c-1);// east
        numberOfIslands(board,r,c+1);// west
        numberOfIslands(board,r+1,c);// south
    }
}