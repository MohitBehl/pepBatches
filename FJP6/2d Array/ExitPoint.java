import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        int dir = 0; 
        int r = 0 , c = 0;
        while(r >= 0 && r < nr && c >= 0 && c < nc){
            dir = (dir + mat[r][c])%4;
            
            if(dir == 0){
                c += 1;
                // c = c + 1;
            }else if(dir == 1){
                r += 1;
            }else if(dir == 2){
                c -= 1;
            }else{
                r -= 1;
            }
        }
        if(dir == 0){
            c -= 1;
            // c = c + 1;
        }else if(dir == 1){
            r -= 1;
        }else if(dir == 2){
            c += 1;
        }else{
            r += 1;
        }
        System.out.println(r);
        System.out.println(c);
    }

}