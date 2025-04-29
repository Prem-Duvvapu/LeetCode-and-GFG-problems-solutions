class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];

        for (int i=0;i<n;i++)
            for (int j=0;j<2;j++)
                for (int l=0;l<k+1;l++)
                    dp[i][j][l]=-1;

        return solve(0,1,k,dp,prices);
    }

    public int solve(int pos,int canBuy,int k,int[][][] dp,int[] prices) {
        if (k==0)
            return 0;

        if (pos==prices.length)
            return 0;

        if (dp[pos][canBuy][k]!=-1)
            return dp[pos][canBuy][k];

        int maxRes=0;

        if (canBuy==1) {
            //buy
            int buy= -1*prices[pos] + solve(pos+1,0,k,dp,prices);

            //buy later
            int buyLater=solve(pos+1,1,k,dp,prices);

            maxRes=Math.max(buy,buyLater);
        } else {
            //sell
            int sell=prices[pos] + solve(pos+1,1,k-1,dp,prices);

            //sell later
            int sellLater=solve(pos+1,0,k,dp,prices);

            maxRes=Math.max(sell,sellLater);
        }
        
        return dp[pos][canBuy][k]=maxRes;
    }
}
