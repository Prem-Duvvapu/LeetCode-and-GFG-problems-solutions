class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];

        for (int i=0;i<n;i++)
            for (int j=0;j<=amount;j++)
                dp[i][j]=-1;

        int res=solve(n-1,coins,amount,dp);

        if (res==(int)1e5)
            return -1;

        return res;
    }

    private int solve(int pos,int[] coins,int amount,int[][] dp) {
        if (amount==0)
            return 0;

        if (pos==0) {
            if (amount%coins[pos]==0)
                return amount/coins[pos];

            return (int)1e5;
        }

        if (dp[pos][amount]!=-1)
            return dp[pos][amount];

        int notPick=solve(pos-1,coins,amount,dp);
        int pick=(int)1e5;
        if (coins[pos]<=amount)
            pick=1+solve(pos,coins,amount-coins[pos],dp);


        return dp[pos][amount]=Math.min(pick,notPick);
    }
}