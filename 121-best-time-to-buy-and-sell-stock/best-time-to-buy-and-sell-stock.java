//Assume you are selling on the current day. So you buy the stock at the cheapest price possible

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int boughtPrice = prices[0];

        for (int i = 1; i < n; i++) {
            int currProfit = prices[i] - boughtPrice;
            maxProfit = Math.max(maxProfit, currProfit);
            boughtPrice = Math.min(boughtPrice, prices[i]);
        }

        return maxProfit;
    }
}