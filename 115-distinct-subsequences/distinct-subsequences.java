//Tabulation(right shift by 1)

class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        long[][] dp=new long[n+1][m+1];
        
        for (int i=0;i<=n;i++)
            dp[i][0]=1;

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=m;j++)
            {
                if (s.charAt(i-1)==t.charAt(j-1))
                {
                    if (dp[i-1][j-1]+dp[i-1][j] > Integer.MAX_VALUE)
                        dp[i][j]=Integer.MAX_VALUE;
                    else
                        dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else
                {
                    if (dp[i-1][j]>Integer.MAX_VALUE)
                        dp[i][j]=Integer.MAX_VALUE;
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
        }

        if (dp[n][m]==Integer.MAX_VALUE)
            return -1;

        return (int)dp[n][m];
    }
}