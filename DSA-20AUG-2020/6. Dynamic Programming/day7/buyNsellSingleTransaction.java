import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nDays = scn.nextInt();
        
        int prices[] = new int[nDays];
        for(int i = 0 ; i < nDays ; i++){
            prices[i] = scn.nextInt();
        }
        
        System.out.println(buySell1transaction(prices));
    }
    
    public static int buySell1transaction(int prices[]){
        int buyPrice = prices[0];
        int overallProfit = 0;
        
        for(int sellPt = 1 ; sellPt < prices.length ; sellPt++){
            int sellPrice = prices[sellPt];
            
            if(sellPrice < buyPrice){
                buyPrice = sellPrice;
            }
            
            int transactionProfit = sellPrice - buyPrice;
            
            if(transactionProfit > overallProfit){
                overallProfit = transactionProfit;
            }
        }
        
        return overallProfit;
    }

}