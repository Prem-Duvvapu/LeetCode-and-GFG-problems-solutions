class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                } else {
                    int moveI = dp[i][j+1];
                    int moveJ = dp[i+1][j];
                    dp[i+1][j+1] = Math.max(moveI,moveJ);
                }
            }
        }

        return dp[n][m];
    }

    private int solve(int i,int j,String text1,String text2,int[][] dp) {
        if (i<0 || j<0)
            return 0;

        if (dp[i][j]!=-1)
            return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j))
            return 1+solve(i-1,j-1,text1,text2,dp);

        int moveI = solve(i-1,j,text1,text2,dp);
        int moveJ = solve(i,j-1,text1,text2,dp);

        return dp[i][j] = Math.max(moveI,moveJ);
    }
}