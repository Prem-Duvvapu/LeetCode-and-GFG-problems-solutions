//Memoization

class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][3];
        for (int[][] arr: dp)
            for (int[] arr2: arr)
                Arrays.fill(arr2,-1);
        return solve(0,1,0,prices,dp);
    }

    private int solve(int pos,int canBuy,int cnt,int[] prices,int[][][] dp)
    {
        if (cnt==2 || pos==prices.length)
            return 0;

        if (dp[pos][canBuy][cnt]!=-1)
            return dp[pos][canBuy][cnt];

        if (canBuy==1)
        {
            int buy=-prices[pos]+solve(pos+1,0,cnt,prices,dp);
            int notBuy=solve(pos+1,1,cnt,prices,dp);
            return dp[pos][canBuy][cnt]=Math.max(buy,notBuy);
        }
        
        //sell
        int sell=prices[pos]+solve(pos+1,1,cnt+1,prices,dp);
        int notSell=solve(pos+1,0,cnt,prices,dp);
        return dp[pos][canBuy][cnt]=Math.max(sell,notSell);
    }
}