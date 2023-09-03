//Tabulation(right shift by 1)

class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];

        for (int j=0;j<=m;j++)
            dp[0][j]=j;

        for (int i=0;i<=n;i++)
            dp[i][0]=i;

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=m;j++)
            {
                int match=1000,insert=1000,delete=1000,replace=1000;
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    match=dp[i-1][j-1];
                else
                {
                    insert=1+dp[i][j-1];
                    delete=1+dp[i-1][j];
                    replace=1+dp[i-1][j-1];
                }


                dp[i][j]=Math.min(Math.min(match,insert),Math.min(delete,replace));
            }
        }

        return dp[n][m];
    }
}