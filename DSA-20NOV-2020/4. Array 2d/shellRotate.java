import java.util.Scanner;

public class shellRotate {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        int sNo = scn.nextInt();
        int k = scn.nextInt();

        shellrotate(mat,sNo,k);
        display(mat);
    }

    public static void shellrotate(int mat[][],int sNo,int k){
        int oneD[] = get1dArr(mat,sNo);
        rotate(oneD,k);
        fill1dArr(mat, sNo, oneD);
    }
    public static void fill1dArr(int mat[][],int sNo,int oneD[]){
        int minr = sNo-1;
        int maxr = mat.length-sNo;
        int minc = sNo-1;
        int maxc = mat[0].length-sNo;

        int idx = 0;
        // left wall
        for(int i = minr , j = minc ; i <= maxr ; i++){
           mat[i][j] = oneD[idx];
           idx++;
        }

        // bottom wall
        for(int i = maxr , j = minc+1 ; j <= maxc ; j++){
            mat[i][j] = oneD[idx];
           idx++;
        }

        // right wall
        for(int i = maxr-1 , j = maxc ; i >= minr ; i--){
            mat[i][j] = oneD[idx];
           idx++;
        }
        
        // top wall
        for(int i = minr , j = maxc-1 ; j >= minc+1 ; j--){
            mat[i][j] = oneD[idx];
           idx++;
        }
    }
    public static int[] get1dArr(int mat[][],int sNo){
        int minr = sNo-1;
        int maxr = mat.length-sNo;
        int minc = sNo-1;
        int maxc = mat[0].length-sNo;

        int size = 2*(maxr-minr + maxc-minc);
        int oneD[] = new int[size];
        int idx = 0;

        // left wall
        for(int i = minr , j = minc ; i <= maxr ; i++){
           oneD[idx] = mat[i][j];
           idx++;
        }

        // bottom wall
        for(int i = maxr , j = minc+1 ; j <= maxc ; j++){
           oneD[idx] = mat[i][j];
           idx++;
        }

        // right wall
        for(int i = maxr-1 , j = maxc ; i >= minr ; i--){
           oneD[idx] = mat[i][j];
           idx++;
        }
        
        // top wall
        for(int i = minr , j = maxc-1 ; j >= minc+1 ; j--){
           oneD[idx] = mat[i][j];
           idx++;
        }

        return oneD;
    }
    public static void rotate(int oneDArray[] , int k){
        // true rotation 
        k = k % oneDArray.length;

        // -ve rotation 
        if(k < 0){
            k = k + oneDArray.length;
        }

        // arr -> p1 + p2
        // reverse p2
        reverse(oneDArray,oneDArray.length-k,oneDArray.length-1);
        // reverse p1
        reverse(oneDArray,0,oneDArray.length-k-1);
        // reverse arr
        reverse(oneDArray,0,oneDArray.length-1);
    }

    public static void reverse(int oneDArray[],int lo,int hi){
        while(lo < hi){
            int temp = oneDArray[lo];
            oneDArray[lo] = oneDArray[hi];
            oneDArray[hi] = temp;
            
            lo++;
            hi--;
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
}
