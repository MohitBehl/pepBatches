import java.util.Scanner;

public class L005 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            prices[i] = scn.nextInt();
        }
        // int tFee = scn.nextInt();
        // System.out.println(buyAndSell1TransactionAllowed(prices));
        // System.out.println(buyAndSellInfinteTransactionAllowed(prices));
        // System.out.println(buyAndSellInfiniteTransactionsWithFee(prices,tFee));
        System.out.println(buyAnsSellInfinteTransactionsWithCoolDown(prices));
    }

    public static int buyAndSellInfinteTransactionAllowed(int prices[]){
        int sp = 0 , bp = 0 , profit = 0;

        for(int day = 1 ; day < prices.length ; day++){
            if(prices[day] >= prices[day-1]){
                sp = day;
            }else{
                profit += prices[sp] - prices[bp];
                sp = day;
                bp = day;
            }
        }
        profit += prices[sp] - prices[bp];

        return profit;
    }
    public static int buyAndSell1TransactionAllowed(int prices[]){
        int oProfit = 0 , cProfit = 0 , buyDay = 0;

        for(int day = 1 ; day < prices.length ; day++){
            if(prices[day] < prices[buyDay]){
                buyDay = day;
            }

            cProfit = prices[day] - prices[buyDay];

            if(cProfit > oProfit){
                oProfit = cProfit;
            }
        }

        return oProfit;
    }

    public static int buyAndSellInfiniteTransactionsWithFee(int prices[],int tFee){
        int oBSP = 0 , oSSP = 0;

        for(int day = 0 ; day < prices.length ; day++){
            if(day == 0){
                oBSP = -prices[0];
            }else{
                int nBSP = Math.max(oSSP - prices[day] , oBSP);
                int nSSP = Math.max(oSSP, prices[day]-tFee + oBSP);
                oBSP = nBSP;
                oSSP = nSSP;
            }
        }

        return oSSP;
    }

    public static int buyAnsSellInfinteTransactionsWithCoolDown(int prices[]){
        int oBSP = 0 , oSSP = 0 , oCSP = 0;
        
        for(int day = 0 ; day < prices.length ; day++){
            if(day == 0){
                oBSP = -prices[0];
            }else{
                int nBSP = Math.max(oBSP , oCSP-prices[day]);
                int nSSP = Math.max(oSSP , prices[day] + oBSP);
                int nCSP = oSSP;

                oBSP = nBSP;
                oSSP = nSSP;
                oCSP = nCSP;
            }
        }

        return oSSP;
    }
}
