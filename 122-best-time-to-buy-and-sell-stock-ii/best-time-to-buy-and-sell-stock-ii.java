//Memoization

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return solve(0,1,prices,dp);
    }

    private int solve(int pos,int canBuy,int[] prices,int[][] dp)
    {
        if (pos==prices.length)
            return 0;

        if (dp[pos][canBuy]!=-1)
            return dp[pos][canBuy];

        if (canBuy==1)
        {
            int buy=-prices[pos]+solve(pos+1,0,prices,dp);
            int notBuy=solve(pos+1,1,prices,dp);
            return dp[pos][canBuy]=Math.max(buy,notBuy);
        }
        
        //sell
        int sell=prices[pos]+solve(pos+1,1,prices,dp);
        int notSell=solve(pos+1,0,prices,dp);
        return dp[pos][canBuy]=Math.max(sell,notSell);
    }
}