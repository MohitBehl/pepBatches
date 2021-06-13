public class BuyAndSell {
    public static int BuyAndSellTwoTransactionAllowed(int price[]){
        int pBD[] = profitConsideringBuyingDay(price);
        int pSD[] = profitConsideringSellingDay(price);
        
        // cumulative maximum
        for(int i = price.length-2 ; i>= 0; i--){
            pBD[i] = Math.max(pBD[i],pBD[i+1]);
        }
        for(int i = 1 ; i < price.length ; i++){
            pSD[i] = Math.max(pSD[i],pSD[i-1]);
        }
        
        int omax = 0;
        for(int i = 0 ; i < price.length ; i++){
            omax = Math.max(omax,pBD[i]+pSD[i]);
        }
        return omax;
    }
    public static int[] profitConsideringBuyingDay(int price[]){
        int res[] = new int[price.length];
        
        int bestSell = price[price.length-1];
        
        for(int i = price.length-2 ; i >= 0 ; i--){
            if(price[i] > bestSell){
                bestSell = price[i];
            }else{
                res[i] = bestSell - price[i];
            }
        }
        
        return res;
    }
    public static int[] profitConsideringSellingDay(int price[]){
        int res[] = new int[price.length];
        
        int bestBuy = price[0];
        
        for(int i = 1 ; i < price.length ; i++){
            if(price[i] < bestBuy){
                bestBuy = price[i];
            }else{
                res[i] = price[i] - bestBuy;
            }
        }
        
        return res;
    }
    public static int BuyAndSellOneTransactionAllowed(int price[]){
        int bestBuy = price[0] , maxProfit = 0;
        
        for(int i = 1 ; i < price.length ; i++){
            if(price[i] < bestBuy){
                bestBuy = price[i];
            }else{
                if(price[i]-bestBuy > maxProfit){
                    maxProfit = price[i]-bestBuy;
                }
            }
        }
        
        return maxProfit;
    }
    public static int BuyAndSellStockInfinteTransactionAllowed(int price[]){
        int bp = 0 , sp = 0 , profit = 0;
        
        for(int day = 1 ; day < price.length ; day++){
            if(price[day] >= price[day-1]){
                sp = day;
            }else{
                profit += price[sp] - price[bp];
                sp = bp = day;
            }
        }
        profit += price[sp]-price[bp];
        return profit;
    }

    public static int BuyAndSellStockInfinteTransactionWithTransactionFee(int price[],int fee){
        int oBSP = -price[0] , oSSP = 0;
        for(int i = 1 ; i < price.length ; i++){
            int nBSP = Math.max(oBSP,oSSP-price[i]);
            int nSSP = Math.max(oSSP,price[i]-fee+oBSP);
            
            oBSP = nBSP;
            oSSP = nSSP;
        }
        
        return oSSP;
    }

    public static int BuyAndSellStockInfinteTransactionWithCooldown(int price[]){
        int oBSP = -price[0] , oSSP = 0,oCSP = 0;
        for(int i = 1 ; i < price.length ; i++){
            int nBSP = Math.max(oBSP,oCSP-price[i]);
            int nSSP = Math.max(oSSP,price[i]+oBSP);
            int nCSP = oSSP;
            
            oBSP = nBSP;
            oSSP = nSSP;
            oCSP = nCSP;
        }
        
        return oSSP;
    }
}
