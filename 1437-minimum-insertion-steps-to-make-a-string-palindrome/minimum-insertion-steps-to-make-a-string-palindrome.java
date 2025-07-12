class Solution {
    public int minInsertions(String s) {
        String text1 = s;
        String text2 = new StringBuilder(text1).reverse().toString();
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        if (text1.charAt(0) == text2.charAt(0))
            dp[0][0] = 1;

        for (int j=1;j<m;j++)
            dp[0][j] = (text1.charAt(0)==text2.charAt(j)) ? 1 : dp[0][j-1];

        for (int i=1;i<n;i++)
            dp[i][0] = (text1.charAt(i)==text2.charAt(0)) ? 1 : dp[i-1][0];

        for (int i=1;i<n;i++) {
            for (int j=1;j<m;j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    int moveI = dp[i-1][j];
                    int moveJ = dp[i][j-1];
                    dp[i][j] = Math.max(moveI,moveJ);
                }
            }
        }

        int lps = dp[n-1][m-1];
        return (n-lps);
    }
}