class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        int[] curr = new int[n2];
        int[] prev = new int[n2];
        
        if (text1.charAt(0) == text2.charAt(0))
            prev[0] = 1;

        // for (int i=1;i<n1;i++) {
        //     if (text1.charAt(i) == text2.charAt(0))
        //         dp[i][0] = 1;
        //     else
        //         dp[i][0] = dp[i-1][0];
        // }

        for (int j=1;j<n2;j++) {
            if (text1.charAt(0) == text2.charAt(j))
                prev[j] = 1;
            else
                prev[j] = prev[j-1];
        }

        for (int i=1;i<n1;i++) {
            if (text1.charAt(i) == text2.charAt(0))
                curr[0] = 1;
            else
                curr[0] = prev[0];

            for (int j=1;j<n2;j++) {
                if (text1.charAt(i)==text2.charAt(j)) {
                    curr[j] = 1+prev[j-1];
                } else {
                    int moveI=prev[j];
                    int moveJ=curr[j-1];
                    curr[j] = Math.max(moveI,moveJ);
                }
            }

            for (int k=0;k<n2;k++)
                prev[k] = curr[k];
        }

        return prev[n2-1];
    }

    public int solve(int i,int j,String text1,String text2,int[][] dp) {
        if (i<0 || j<0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (text1.charAt(i)==text2.charAt(j))
            return dp[i][j] = 1+solve(i-1,j-1,text1,text2,dp);

        int moveI=solve(i-1,j,text1,text2,dp);
        int moveJ=solve(i,j-1,text1,text2,dp);

        return dp[i][j] = Math.max(moveI,moveJ);
    }
}