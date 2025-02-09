class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        int minPrice=prices[0];

        for (int i=0;i<n;i++) {
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
            minPrice=Math.min(minPrice,prices[i]);
        }

        return maxProfit;
    }
}