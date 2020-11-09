import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        
        int buyPt = 0;
        int sellPt = 0;
        int profit = 0;
        
        for(int i = 1; i < arr.length ; i++){
            if(arr[i] < arr[i-1]){
                // loss
                
                // complete previous transaction
                profit += (arr[sellPt] - arr[buyPt]);
                
                // update buyPt &  sellPt
                buyPt = sellPt = i;
                
            }else{
                // profit
                sellPt++;
            }
        }
        
        //  complete the last transaction
        profit += (arr[sellPt] - arr[buyPt]);
        
        System.out.println(profit);
    }

}