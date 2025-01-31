class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n][m];

        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                dp[i][j]=-1;

        for (int i=0;i<n;i++)
            if (text1.charAt(i)==text2.charAt(0))
                dp[i][0]=1;

        for (int j=1;j<m;j++)
            if (text1.charAt(0)==text2.charAt(j))
                dp[0][j]=1;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (text1.charAt(i)==text2.charAt(j) && i>0 && j>0)
                    dp[i][j]=1+dp[i-1][j-1];
                else {
                    int l=0;
                    if (i>0)
                        l=dp[i-1][j];
                    int r=0;
                    if (j>0)
                        r=dp[i][j-1];
                    dp[i][j]=Math.max(dp[i][j],Math.max(l,r));
                }
            }
        }

        return dp[n-1][m-1];
    }

    // private int solve(int i,int j,String text1,String text2,int[][] dp) {
    //     if (i<0 || j<0)
    //         return 0;

    //     if (dp[i][j]!=-1)
    //         return dp[i][j];

    //     if (text1.charAt(i)==text2.charAt(j))
    //         return dp[i][j]=1+solve(i-1,j-1,text1,text2,dp);

    //     return dp[i][j]=Math.max(solve(i-1,j,text1,text2,dp), solve(i,j-1,text1,text2,dp));
    // }
}