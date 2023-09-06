//Tabulation

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        
        for (int i=n-1;i>=0;i--)
        {
            for (int j=0;j<=1;j++)
            {
                if (j==1)
                {
                    int buy=-prices[i];
                    int notBuy=0;
                    if (i<n-1)
                    {
                        buy+=dp[i+1][0];
                        notBuy=dp[i+1][1];
                    }
                    dp[i][j]=Math.max(buy,notBuy);
                }
                else
                {
                    int sell=prices[i];
                    int notSell=0;
                    if (i<n-1)
                    {
                        sell+=dp[i+1][1];
                        notSell=dp[i+1][0];
                    }
                    dp[i][j]=Math.max(sell,notSell);
                }
            }
        }

        return dp[0][1];
    }
}