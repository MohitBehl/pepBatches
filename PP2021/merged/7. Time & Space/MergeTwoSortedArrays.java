import java.io.*;
import java.util.*;

public class Main {

  public static int[] MergeTwoSortedArrays(int[] a, int[] b){
    int n1 = a.length , n2 = b.length;
    int res[] = new int[n1+n2];
    
    int i = 0 , j = 0, k = 0;
    
    while(i < n1 && j < n2){
        if(a[i] <= b[j]){
            res[k] = a[i];
            i++;
            k++;
        }else{
            res[k] = b[j];
            j++;
            k++;
        }
    }
    
    while(i < n1){
        res[k] = a[i];
        i++;
        k++;
    }
    
    while(j < n2){
        res[k] = b[j];
        j++;
        k++;
    }
    return res;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}