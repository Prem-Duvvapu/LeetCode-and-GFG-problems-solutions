class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int lcs=longestCommonSubsequence(word1,word2,n,m);
        return ((n-lcs)+(m-lcs));
    }

    private int longestCommonSubsequence(String s,String t,int n,int m)
    {
        int[][] dp=new int[n+1][m+1];

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=m;j++)
            {
                if (s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}