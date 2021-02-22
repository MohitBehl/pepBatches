public class arrays2d {
    public static void main(String[] args) {
        int mat[][] = new int[3][2];

        mat[0][0] = 1;
        mat[0][1] = 2;

        mat[1][0] = 16;
        mat[1][1] = 22;

        mat[2][0] = 10;
        mat[2][1] = 20;

        for(int r = 0 ; r < 3 ; r++){
            for(int c = 0 ; c < 2 ; c++){
                System.out.print("["+r+"]"+"["+c+"] : "+mat[r][c] +"\t");
            }
            System.out.println();
        }
    }
}
