import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        
        printAllSubarrays(arr);
    }
    
    public static void printAllSubarrays(int arr[]){
        for(int i = 0 ; i < arr.length ; i++){ // starting point
            for(int j = i ; j < arr.length ; j++){ // ending point
                
                int sp = i;
                int ep = j;
                for(int idx = sp ; idx <= ep ; idx++){
                    System.out.print(arr[idx]+"	");
                }
                System.out.println();
            }
        }
    }

}