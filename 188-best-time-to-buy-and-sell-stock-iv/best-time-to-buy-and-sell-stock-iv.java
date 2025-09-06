class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];

        for (int i=0;i<n;i++)
            for (int j=0;j<=k;j++)
                for (int l=0;l<2;l++)
                    dp[i][j][l] = -1;

        return solve(0, k, 1, prices, n,dp);
    }

    public int solve(int pos,int k,int canBuy,int[] prices,int n,int[][][] dp) {
        if (k == 0 || pos == n)
            return 0;

        if (dp[pos][k][canBuy] != -1)
            return dp[pos][k][canBuy];

        int currRes = 0;

        if (canBuy == 1) {
            // buy
            int buy = -1 * prices[pos] + solve(pos+1, k, 0, prices, n,dp);

            // not buy
            int notBuy = 0 + solve(pos+1, k, 1, prices, n,dp);

            currRes = Math.max(buy, notBuy);
        } else {
            // sell
            int sell = prices[pos] + solve(pos+1, k-1, 1, prices, n,dp);

            // not sell
            int notSell = 0 + solve(pos+1, k, 0, prices, n,dp);

            currRes = Math.max(sell, notSell);
        }

        return dp[pos][k][canBuy] = currRes;
    }

}

// recursive -> memoization

// pos = 0 to n
// k = 0 to k
// canBuy = 0 to 1

/*
memoization
1. observe the changing the variables in recurive function
2. write ranges for each changing variables (minval to maxVal range)
3. intialize the dp with -1 (intialize with value you will never came across)
4. pass it in function
5. 
*/

// prices = [3,2,6,5,0,3]
// n = prices.length;
// k=2

// maximum profit
// at max. k transactions - can be done in multiple ways (explore all possibilites with given conditiosns)
// from this recursion

// from constraints - memoization

