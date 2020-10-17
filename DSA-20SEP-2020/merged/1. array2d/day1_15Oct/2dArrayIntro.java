import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int arr[][] = new int[nr][nc];


        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        // int arr[][] = {
        //     {1,2,3},
        //     {4,5,6},
        //     {7,8,9}
        // };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

    }
}