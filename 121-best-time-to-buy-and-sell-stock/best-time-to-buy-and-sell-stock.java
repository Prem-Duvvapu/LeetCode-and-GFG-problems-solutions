class Solution {
    public int maxProfit(int[] prices) {
        int minVal=prices[0];
        int maxProfit=0;

        for (int i=1;i<prices.length;i++)
        {
            int currProfit=prices[i]-minVal;
            maxProfit=Math.max(currProfit,maxProfit);
            minVal=Math.min(minVal,prices[i]);
        }

        return maxProfit;
    }
}