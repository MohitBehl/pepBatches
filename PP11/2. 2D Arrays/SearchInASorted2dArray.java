import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int mat[][] = new int[n][n];

    for (int i = 0 ; i < n ; i++) {
      for (int j = 0 ; j < n ; j++) {
        mat[i][j] = scn.nextInt();
      }
    }
    int x = scn.nextInt();
    // logic
    int i = 0, j = n - 1;

    while (j >= 0 && i < n) {
      if (mat[i][j] == x) {
        System.out.println(i);
        System.out.println(j);
        return;
      } else if (x < mat[i][j]) {
        j--;
      } else if (x > mat[i][j]) {
        i++;
      }
    }

    System.out.println("Not Found");
  }

}