import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        fillMatrix(mat, scn);
        // display(mat);
        stateOfWakanda1(mat);
    }
    public static void fillMatrix(int mat[][],Scanner scn){
        int nr = mat.length;
        int nc = mat[0].length;
        for(int r = 0 ; r < nr ; r++){
            for(int c = 0 ; c < nc ; c++){
                mat[r][c] = scn.nextInt();
            }
        }
    }
    public static void display(int mat[][]){
        int nr = mat.length;
        int nc = mat[0].length;
        for(int r = 0 ; r < nr ; r++){
            for(int c = 0 ; c < nc ; c++){
                System.out.print(mat[r][c]+" ");
            }
            System.out.println();
        }
    }

    public static void stateOfWakanda1(int mat[][]){
        int nc = mat[0].length;
        int nr = mat.length;
        for(int c = 0 ; c < nc ; c++){
            if(c%2 == 0){ // even ,  top -> bottom
                for(int r = 0 ; r < nr ; r++){
                    System.out.println(mat[r][c]);
                }
            }else{ // odd , bottom ->  top
                for(int r = nr-1 ; r >= 0 ; r--){
                    System.out.println(mat[r][c]);
                }
            }
        }
    }

    public static void stateOfWakanda2(int mat[][]){
        int n = mat.length;
        for(int gap = 0 ; gap < n ; gap++){
            int r = 0 , c = gap;

            while(r < n && c < n){
                System.out.println(mat[r][c]);
                r++;
                c++;
            }
        }
    }
}
