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

    public static void spiralDisplay(){
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt() , nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        for(int i = 0; i < nr ; i++){
            for(int j = 0; j< nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }

        // main logic
        int rmin = 0, cmin = 0 , rmax = nr-1 , cmax = nc-1 , count = 0;
        int TotalNoOfEle = nr*nc;
        while(count < TotalNoOfEle){
            //left wall 
            for(int i = rmin ; i <= rmax ; i++){
                System.out.println(mat[i][cmin]);
                count++;
            }
            cmin++;
            // bottom wall 
            for(int j = cmin ; j <= cmax && count < TotalNoOfEle; j++){
                System.out.println(mat[rmax][j]);
                count++;
            }
            rmax--;
            // right wall
            for(int i = rmax ; i >= rmin && count < TotalNoOfEle; i--){
                System.out.println(mat[i][cmax]);
                count++;
            }
            cmax--;
            // top wall
            for(int j = cmax ; j >= cmin && count < TotalNoOfEle; j--){
                System.out.println(mat[rmin][j]);
                count++;
            }
            rmin++;
        }
    }
    
    public static void exitPoint(){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int grid[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0; j< nc ; j++){
                grid[i][j] = scn.nextInt();
            }
        }

        // logic

        int i = 0 , j = 0;
        int dir = 0; // 0 - E , 1 - S , 2 - W , 3 - N

        while(true){
            dir = (dir + grid[i][j])%4;

            if(dir == 0){
                // move east
                j++;
            }else if(dir == 1){
                // move south
                i++;
            }else if(dir == 2){
                // move west
                j--;
            }else if(dir == 3){
                // move north
                i--;
            }

            if(i == -1){
                // exited through top wall
                i = 0;
                break;
            }else if(j == grid[0].length){
                // exited through right wall
                j = grid[0].length-1;
                break;
            }else if(i == grid.length){
                // exited through bottom wall
                i = grid.length-1;
                break;
            }else if(j == -1){
                // exited through left wall
                j = 0;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }
    
    public static void searchInSorted2dArr(){
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = nr;
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        int ele = scn.nextInt();

        // main logic
        int i = 0  , j = mat[0].length-1;

        while(j >= 0 && i < mat.length){
            if(ele < mat[i][j]){
                // smaller
                j--;
            }else if(ele > mat[i][j]){
                // larger
                i++;
            }else if(ele == mat[i][j]){
                // element found
                System.out.println(i+"\n"+j);
                return;
            }
        }
        System.out.println("Not Found");
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
