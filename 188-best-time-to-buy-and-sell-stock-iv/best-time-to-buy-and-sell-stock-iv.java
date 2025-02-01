class Solution {
    public int maxProfit(int k,int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];

        for (int i=0;i<n;i++)
            for (int j=0;j<2;j++)
                for (int l=0;l<=k;l++)
                    dp[i][j][l]=-1;

        return solve(0,prices,1,k,dp);
    }

    private int solve(int pos,int[] prices,int canBuy,int count,int[][][] dp) {
        if (pos==prices.length || count==0)
            return 0;

        if (dp[pos][canBuy][count]!=-1)
            return dp[pos][canBuy][count];

        int res=0;
        int b=0;
        int s=0;
        if (canBuy==1) {
            int bought=-1*prices[pos]+solve(pos+1,prices,0,count,dp);
            int notBought=0+solve(pos+1,prices,canBuy,count,dp);
            b=Math.max(bought,notBought);
        } else {
            int sell=prices[pos]+solve(pos+1,prices,1,count-1,dp);
            int notSell=0+solve(pos+1,prices,canBuy,count,dp);
            s=Math.max(sell,notSell);
        }

        return dp[pos][canBuy][count]=Math.max(b,s);
    }
}