//Tabulation

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int[][] dp=new int[n][n];

        for (int i=0;i<n;i++)
            dp[0][i]=grid[0][i];

        for (int i=1;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                int minVal=Integer.MAX_VALUE;
                for (int k=0;k<n;k++)
                {
                    if (k!=j)
                        minVal=Math.min(minVal,dp[i-1][k]);
                }
                dp[i][j]=grid[i][j]+minVal;
            }
        }

        int minVal=Integer.MAX_VALUE;
        for (int i=0;i<n;i++)
            minVal=Math.min(dp[n-1][i],minVal);

        return minVal;
    }
}