class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];

        for (int i=0;i<n;i++)
            for (int j=0;j<2;j++)
                Arrays.fill(dp[i][j],-1);

        return solve(0,1,k,prices,dp);
    }

    private int solve(int pos,int canBuy,int k,int[] prices,int[][][] dp) {
        if (k==0 || pos==prices.length)
            return 0;

        if (dp[pos][canBuy][k]!=-1)
            return dp[pos][canBuy][k];

        if (canBuy==1) {
            int buy = -prices[pos] + solve(pos+1,1^canBuy,k,prices,dp);
            int notBuy = solve(pos+1,canBuy,k,prices,dp);

            return dp[pos][canBuy][k] = Math.max(buy,notBuy);
        } else {
            int sell = prices[pos] + solve(pos+1,1^canBuy,k-1,prices,dp);
            int notSell = solve(pos+1,canBuy,k,prices,dp);

            return dp[pos][canBuy][k] = Math.max(sell,notSell);
        }
    }
}