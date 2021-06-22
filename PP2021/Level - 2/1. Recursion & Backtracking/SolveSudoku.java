
// import java.io.*;
import java.util.*;

public class SolveSudoku {
  public static void display(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
  public static boolean isValid(int board[][], int r, int c, int num) {
    for (int i = r, j = 0 ; j <= 8 ; j++) {
      if (board[i][j] == num) {
        return false;
      }
    }

    for (int i = 0, j = c ; i <= 8 ; i++) {
      if (board[i][j] == num) {
        return false;
      }
    }

    int tr = (r / 3) * 3, tc = 3 * (c / 3);
    for (int i = 0 ; i < 3 ; i++) {
      for (int j = 0 ; j < 3 ; j++) {
        if (board[tr + i][tc + j] == num) {
          return false;
        }
      }
    }
    return true;
  }
  public static void solveSudoku(int[][] board, int r, int c) {
    if (r == 9) {
      display(board);
      return;
    }
    int nr, nc;
    if (c == 8) {
      nr = r + 1;
      nc = 0;
    } else {
      nr = r;
      nc = c + 1;
    }
    if (board[r][c] != 0) {
      solveSudoku(board, nr, nc);
    } else {
      for (int num = 1 ; num <= 9 ; num++) {
        if (isValid(board, r, c, num)) {
          board[r][c] = num;
          solveSudoku(board, nr, nc);
          board[r][c] = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
