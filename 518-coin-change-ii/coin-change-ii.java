class Solution {
    private int helper(int pos,int amount,int[] coins,int[][] dp)
    {
        if (amount==0)
            return 1;
        else if (pos==coins.length || coins[pos]>amount)
            return 0;

        if (dp[pos][amount]!=-1)
            return dp[pos][amount];

        int take=helper(pos,amount-coins[pos],coins,dp);
        int notTake=helper(pos+1,amount,coins,dp);

        return dp[pos][amount]=take+notTake;
    }

    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        for (int[] a: dp)
            Arrays.fill(a,-1);

        Arrays.sort(coins);
        return helper(0,amount,coins,dp);
    }
}