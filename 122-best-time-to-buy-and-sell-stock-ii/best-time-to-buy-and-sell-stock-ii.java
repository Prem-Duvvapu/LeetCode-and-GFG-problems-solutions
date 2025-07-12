class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        return solve(0,1,prices,dp);
    }

    private int solve(int pos,int canBuy,int[] prices,int[][] dp) {
        if (pos==prices.length)
            return 0;

        if (dp[pos][canBuy]!=-1)
            return dp[pos][canBuy];

        if (canBuy==1) {
            int buy = -prices[pos] + solve(pos+1,1^canBuy,prices,dp);
            int notBuy = solve(pos+1,canBuy,prices,dp);

            return dp[pos][canBuy] = Math.max(buy,notBuy);
        } else {
            int sell = prices[pos] + solve(pos+1,1^canBuy,prices,dp);
            int notSell = solve(pos+1,canBuy,prices,dp);

            return dp[pos][canBuy] = Math.max(sell,notSell);
        }
    }
}