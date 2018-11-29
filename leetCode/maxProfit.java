/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        
        int profitSoFar = 0;
        int minPrice = prices[0];
        int maxPrice = prices[1] - prices[0];
        
        for(int i= 0; i < prices.length; i++){
            int current = prices[i]; 
            int potentialProfit = current - minPrice;
            profitSoFar = Math.max(profitSoFar, potentialProfit);
            minPrice = Math.min(current, minPrice);
        }
        
        
        return profitSoFar;
       /* 
       int maxprofit = 0;
        for(int i=0; i< prices.length; i++){
            for(int j = 0; j < prices.length; j++){
                int earlierTime = Math.min(i, j);
                int laterTime = Math.max(i, j);
                
                int earlierPrice = prices[earlierTime];
                int laterPrice = prices[laterTime];
                
                int profitPossible= laterPrice - earlierPrice;
                
                maxprofit = Math.max(maxprofit, profitPossible);
            }
        }
        return maxprofit;
        */
    }
}
