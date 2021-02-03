public class Introduction {
    public static void main(String[] args) {
        // // init
        // int mat[][] = new int[3][4];

        // mat[0][0] = 10;
        // mat[0][1] = 0;
        // mat[0][2] = 20;
        // mat[0][3] = 30;

        // mat[1][0] = 4;
        // mat[1][1] = 5;
        // mat[1][2] = 9;
        // mat[1][3] = 11;

        // mat[2][0] = 32;
        // mat[2][1] = 25;
        // mat[2][2] = 16;
        // mat[2][3] = 12;

        

        // int mat1[][] = {
        //     {
        //         1,
        //         2,
        //         3,
        //         4
        //     },
        //     {
        //         5,
        //         6,
        //         7,
        //         8
        //     },
        //     {
        //         9,
        //         10,
        //         11,
        //         12
        //     }
        // };
        
        // display(mat1);
        
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        display(mat);
    }
    
    public static void display(int mat[][]){
        // print
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                System.out.print(mat[r][c] + "\t");
            }
            System.out.println();
        }

        System.out.println("Display using for-each");
        for(int oned[] : mat){
            for(int ele : oned){
                System.out.print(ele+"\t");
            }
            System.out.println();
        }

    }
}
