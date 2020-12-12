import java.util.Scanner;

public class Array2D {

    public static void display(int mat[][]){
        // display
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void matrixMultiplication(){
        Scanner scn = new Scanner(System.in);

        int nrm1 = scn.nextInt(); // no. row of matrix 1
        int ncm1 = scn.nextInt(); // no. col of matrix 1
        int mat1[][] = new int[nrm1][ncm1];
        for(int i = 0 ; i < nrm1 ; i++){
            for(int j = 0 ; j < ncm1 ; j++){
                mat1[i][j] = scn.nextInt();
            }
        }

        int nrm2 = scn.nextInt(); // no. row of matrix 2
        int ncm2 = scn.nextInt(); // no. col of matrix 2
        int mat2[][] = new int[nrm2][ncm2];
        for(int i = 0 ; i < nrm2 ; i++){
            for(int j = 0 ; j < ncm2 ; j++){
                mat2[i][j] = scn.nextInt();
            }
        }

        if(ncm1 == nrm2){
            // matrix multiplication possible
            // resultant matrix : 
            int res[][] = new int[nrm1][ncm2];

            for(int i = 0 ; i < nrm1 ; i++){
                for(int j = 0 ; j < ncm2 ; j++){

                    for(int k = 0 ; k < ncm1 ; k++){
                       res[i][j] += (mat1[i][k]*mat2[k][j]);
                    }
                }
            }
            display(res);
        }else{
            // matrix multiplication not-possible
            System.out.println("Invalid input");
        }
    }


    public static void waveTraversal(){
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt() , nc = scn.nextInt();
        int mat1[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat1[i][j] = scn.nextInt();
            }
        }

        System.out.println("wave");

        // logic for waveTraversal
        for(int col = 0 ; col < nc ; col++){
            if(col%2 == 0){
                // even column : top -> bottom
                for(int row = 0 ; row < nr ; row++){
                    System.out.println(mat1[row][col]);
                }
            }else{
                // odd column : bottom -> top
                for(int row = nr-1 ; row >= 0 ; row--){
                    System.out.println(mat1[row][col]);
                }
            }
        }
    }

    public static void diagonalTraversal(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nr = n , nc = n;
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }

        // logic for diagonal traversal
        for(int gap = 0 ; gap < nc ; gap++){
            for(int i = 0 , j = gap ; i < nr && j <nc ; i++,j++){
                System.out.println(mat[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        // // int mat[][] = new int[3][3];


        // // // value assign 

        // // mat[0][0] = 1;
        // // mat[0][1] = 5;
        // // mat[0][2] = 7;

        // // mat[1][0] = 10;
        // // mat[1][1] = 6;
        // // mat[1][2] = 7;

        // // mat[2][0] = -110;
        // // mat[2][1] = 66;
        // // mat[2][2] = 78;

        // Scanner scn = new Scanner(System.in);

        // int nr = scn.nextInt() , nc = scn.nextInt();
        // int mat1[][] = new int[nr][nc];

        // for(int i = 0 ; i < nr ; i++){
        //     for(int j = 0 ; j < nc ; j++){
        //         mat1[i][j] = scn.nextInt();
        //     }
        // }
        // display(mat1);

        // matrixMultiplication();
        // waveTraversal();
            diagonalTraversal();
    }
}
