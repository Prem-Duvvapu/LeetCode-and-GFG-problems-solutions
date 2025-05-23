class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];

        for (int i=0;i<n;i++)
            for (int j=0;j<2;j++)
                dp[i][j]=-1;

        return solve(0,prices,1,dp);
    }

    private int solve(int pos,int[] prices,int canBuy,int[][] dp) {
        if (pos>=prices.length)
            return 0;

        if (dp[pos][canBuy]!=-1)
            return dp[pos][canBuy];

        int res=0;
        int b=0;
        int s=0;
        if (canBuy==1) {
            int bought=-1*prices[pos]+solve(pos+1,prices,0,dp);
            int notBought=0+solve(pos+1,prices,canBuy,dp);
            b=Math.max(bought,notBought);
        } else {
            int sell=prices[pos]+solve(pos+2,prices,1,dp);
            int notSell=0+solve(pos+1,prices,canBuy,dp);
            s=Math.max(sell,notSell);
        }

        return dp[pos][canBuy]=Math.max(b,s);
    }
}