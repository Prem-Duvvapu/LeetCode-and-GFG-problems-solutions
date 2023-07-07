class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int buy=prices[0];
        int sell=0;

        for (int i=0;i<prices.length;i++)
        {
            if (prices[i]>buy)
                res=Math.max(prices[i]-buy,res);
            else
                buy=prices[i];
        }

        return res;
    }
}