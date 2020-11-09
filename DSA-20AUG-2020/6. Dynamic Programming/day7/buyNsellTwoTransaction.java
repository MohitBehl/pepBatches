import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       
       int n = scn.nextInt();
       int prices[] = new int[n];
       for(int i = 0 ; i < n ; i++){
           prices[i] =  scn.nextInt();
       }
       
        // profit if transaction is settled on a particular day
       int sp[] = new int[n];
       int maxProfit = 0;
       int buyPrice = prices[0];
       for(int sellPt = 1 ; sellPt < n ; sellPt++){
           int sellPrice = prices[sellPt];
           if(sellPrice < buyPrice){
            //   loss
               buyPrice = sellPrice;
           }
           int profitOfDay = sellPrice - buyPrice;
           
           if(maxProfit < profitOfDay){
               maxProfit = profitOfDay;
           }
           
           sp[sellPt] = maxProfit;
       }
       
       // profit if transaction is initiated on a particular day
       int bp[] = new int[n];
       int sellPrice = prices[n-1];
       maxProfit = 0;
       for(int buyPt = n-2 ; buyPt >= 0 ; buyPt--){
           buyPrice = prices[buyPt];
           
           if(buyPrice > sellPrice){
                //loss
                sellPrice = buyPrice;
           }
           
           int profitOfDay = sellPrice - buyPrice;
           
           if(maxProfit < profitOfDay){
               maxProfit = profitOfDay;
           }
           
           bp[buyPt] = maxProfit;
       }
       
       int max = 0;
       for(int i = 0 ; i < n ; i++){
           if(sp[i]+bp[i] > max){
               max = sp[i]+bp[i];
           }
       }
       
       System.out.println(max);
    }

}