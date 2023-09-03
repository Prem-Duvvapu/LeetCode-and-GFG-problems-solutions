//Tabulation

class Solution {
    int mod=(int)(2e9);

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (i==0 && j==0)
                    dp[i][j]=1;
                else
                {
                    int left=0;
                    int top=0;

                    if (j-1>=0)
                        left=dp[i][j-1];
                    
                    if (i-1>=0)
                        top=dp[i-1][j];

                    dp[i][j]=(left+top)%mod;
                }
            }
        }

        return dp[m-1][n-1];
    }
}