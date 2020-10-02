import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int rows = scn.nextInt();
        int cols = scn.nextInt();
        int mat[][] = new int[rows][cols];

        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ;j++){
                mat[i][j] = scn.nextInt();
            }
        }

        int shell = scn.nextInt();
        int rotation = scn.nextInt();

        shellRotate(mat,shell,rotation);
        display(mat);
    }

    public void shellRotate(int mat[][],int s,int r){
        // 1. fill 1d array from mat
        int arr[] = fill1d(mat,s);
        // 2. rotate 1d array
        rotate(arr,r);
        // 3. fill 1d array in mat
        fill2d(mat,s,arr);
    }

    public static int[] fill1d(int mat[][],int s){
        int rmin = s-1 , cmin = s-1 , rmax = mat.length-s; 
        int cmax = mat[0].length-s;

        int n = 2 * (rmax - rmin + cmax - cmin);
        int arr[] = new int[n];
        int idx = 0;

        // left wall
        for(int i = rmin ; i <= rmax ; i++){
            arr[idx] = mat[i][cmin];
            idx++;
        }cmin++;
        // bottom wall
        for(int j = cmin ; j <= cmax ; j++){
            arr[idx] = mat[rmax][j];
            idx++;
        }rmax--;
        // right wall
        for(int i = rmax ; i >= rmin ; i--){
            arr[idx] = mat[i][cmax];
            idx++;
        }
        cmax--;
        // top wall
        for(int j = cmax ; j >= cmin ; j--){
            arr[idx] = mat[rmin][j];
            idx++;
        }

        return arr;
    }
    public static void fill2d(int mat[][] , int s , int arr[]){
        int rmin = s-1 , cmin = s-1 , rmax = mat.length-s , cmax = mat[0].length-s;
        
        int idx = 0;

        // left wall
        for(int i = rmin ; i <= rmax ; i++){
            mat[i][cmin] = arr[idx];
            idx++;
        }cmin++;
        // bottom wall
        for(int j = cmin ; j <= cmax ; j++){
            mat[rmax][j] = arr[idx];
            idx++;
        }rmax--;
        // right wall
        for(int i = rmax ; i >= rmin ; i--){
            mat[i][cmax] = arr[idx];
            idx++;
        }
        cmax--;
        // top wall
        for(int j = cmax ; j >= cmin ; j--){
            mat[rmin][j] = arr[idx];
            idx++;
        }
    }
    public static void rotate(int arr[],int r){
        // 1. true rotation
        r = r % arr.length;

        // 2. -ve rotation --> +ve rotation
        if(r < 0){
            r = r + arr.length;
        }

        // reverse part2 of the array 
        reverse(arr, arr.length - r , arr.length-1);
        // reverse part1 of the array
        reverse(arr, 0 , arr.length - r - 1);
        // reverse complete array
        reverse(arr, 0 , arr.length-1); 
    }
    public static void reverse(int arr[],int si,int ei){
        while(si < ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;

            si++;
            ei--;
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