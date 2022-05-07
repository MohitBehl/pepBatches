import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // // spiral
        // Scanner scn = new Scanner(System.in);

        // int nr = scn.nextInt() , nc = scn.nextInt();
        // int mat[][] = new int[nr][nc];
        // for(int i = 0 ; i < nr ; i++){
        //     for(int j = 0 ; j < nc ; j++){
        //         mat[i][j] = scn.nextInt();
        //     }
        // }

        // spiralDisplay(mat);

        // // ring Rotate
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt() , nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        int shell = scn.nextInt();
        int k = scn.nextInt();

        ringRotate(mat,shell,k);
        display(mat);
    }

    public static void ringRotate(int mat[][],int shell,int k){
        int vals[] = getRing(mat,shell);
        rotate(vals,k);
        updateRing(mat,shell,vals);
    }

    public static int[] getRing(int mat[][],int shell){

    }

    public static void updateRing(int mat[][],int shell,int vals[]){

    }

    public static void rotate(int arr[],int k){
        k = k % arr.length;

        if(k < 0)
            k = k + arr.length;
        
        // reverse part 2
        reverse(arr, arr.length-k, arr.length-1);
        // reverse part 1
        reverse(arr, 0, arr.length-k-1);
        // reverse arr
        reverse(arr, 0, arr.length-1);
    }
    public static void reverse(int arr[],int left,int right){
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
    public static void spiralDisplay(int mat[][]){
        int rmin = 0, cmin = 0, rmax = mat.length-1, cmax = mat[0].length-1;
        int tne = mat.length * mat[0].length;
        int count = 0;
        while(count < tne){
            // left wall
            for(int r = rmin, c = cmin ; r <= rmax && count < tne; r++){
                System.out.println(mat[r][c]);
                count++;    
            }
            // bottom wall
            for(int r = rmax, c = cmin+1 ; c <= cmax && count < tne ; c++){
                System.out.println(mat[r][c]);
                count++;
            }
            // right wall
            for(int r = rmax-1, c = cmax ; r >= rmin && count < tne; r--){
                System.out.println(mat[r][c]);
                count++;
            }
            // top wall
            for(int r = rmin, c = cmax-1 ; c >= cmin+1 && count < tne ; c--){
                System.out.println(mat[r][c]);
                count++;
            }
            rmin++;
            cmin++;
            rmax--;
            cmax--;
        }
    }
}
