class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];
        
        for (int i=0;i<=n;i++)
            for (int j=0;j<=m;j++)
                dp[i][j]=-1;

        return solve(n,m,text1,text2,dp);
    }

    private int solve(int n,int m,String text1,String text2,int[][] dp) {
        if (n==0 || m==0)
            return 0;

        if (dp[n][m]!=-1)
            return dp[n][m];

        if (text1.charAt(n-1)==text2.charAt(m-1))
            return 1+solve(n-1,m-1,text1,text2,dp);

        return dp[n][m]=Math.max(solve(n-1,m,text1,text2,dp),solve(n,m-1,text1,text2,dp));
    }
}