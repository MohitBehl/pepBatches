import java.util.*;

public class L001 {
    public static void main(String[] args) {
        // intro();
        twoDArrayDemo();
    }
    public static void exitPoint(){
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
        int dir = 0;

        int row = 0 , col = 0;
        int prevRow = -1,prevCol = -1;
        while(row >= 0 && col >= 0 && row < mat.length && col < mat[0].length){
            dir = (dir + mat[row][col]) % 4;

            prevRow = row;
            prevCol = col;

            if(dir == 0){
                col++;
            }else if(dir == 1){
                row++;
            }else if(dir == 2){
                col--;
            }else if(dir == 3){
                row--;
            }
        }

        System.out.println(prevRow+"\n"+prevCol);
    }
    public static matrixMultiplication(){
        Scanner scn = new Scanner(System.in);
        int nr1 = scn.nextInt();
        int nc1 = scn.nextInt();
        int mat1[][] = new int[nr1][nc1];
        for(int r = 0 ; r < nr1 ; r++){
            for(int c = 0 ; c < nc1 ; c++){
                mat1[r][c] = scn.nextInt();
            }
        }
    
        int nr2 = scn.nextInt();
        int nc2 = scn.nextInt();
        int mat2[][] = new int[nr2][nc2];
        for(int r = 0 ; r < nr2 ; r++){
            for(int c = 0 ; c < nc2 ; c++){
                mat2[r][c] = scn.nextInt();
            }
        }
    
        
        if(nc1 == nr2){
            // matrix multiplication
            int res[][] = new int[nr1][nc2];
    
            for(int i = 0 ; i < res.length ; i++){
                for(int j = 0 ; j < res[0].length ; j++){
                    for(int k = 0 ; k < nc1 ; k++){
                        res[i][j] += (mat1[i][k] * mat2[k][j]);
                    }
                }
            }
    
            for(int arr[] : res){
                for(int val : arr){
                    System.out.print(val+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println("Invalid input");
        }
    }
    public static void theStateOfWakanda1(){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }

        // logic
        for(int col = 0 ; col < nc ; col++){
            if(col % 2 == 0){
                // even
                for(int row = 0 ; row < nr ; row++){
                    System.out.println(mat[row][col]);
                }
            }else{
                // odd
                for(int row = nr-1 ; row >= 0 ; row--){
                    System.out.println(mat[row][col]);
                }
            }
        }
    }
    public static void twoDArrayDemo(){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int mat[][] = new int[nr][nc];

        for (int r = 0 ; r < nr ; r++) {
            for (int c = 0 ; c < nc ; c++) {
            mat[r][c] = scn.nextInt();
            }
        }

        for (int r = 0 ; r < mat.length ; r++) {
            for (int c = 0 ; c < mat[0].length ; c++) {
                System.out.print(mat[r][c] + " ");
            }
            System.out.println();
        }
    }
    public static void intro(){
        // int mat[][] = {{1,2,3},{4,0,5},{6,1,7}};

        // display(mat);

        int mat1[][] = new int[3][2];

        mat1[0][0] = 100;
        mat1[1][1] = 19;
        mat1[2][0] = 10;

        // display(mat1);
        // display1(mat1);
        display2(mat1);
        
    }

    public static void display(int mat[][]){
        for(int r = 0 ; r < mat.length ; r++){
            for(int c = 0 ;c < mat[0].length ; c++){
              System.out.print(mat[r][c] +"\t");
           }
           System.out.println();
       }
    }

    public static void display1(int mat[][]){
        for(int arr[] : mat){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void display2(int mat[][]){
        for(int arr[] : mat){
            for(int val : arr){
                System.out.print(val +" ");
            }
            System.out.println();
        }
    }
}
