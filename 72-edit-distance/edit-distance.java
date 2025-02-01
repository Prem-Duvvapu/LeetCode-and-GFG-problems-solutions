class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];

        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                dp[i][j]=-1;

        return solve(n-1,m-1,word1,word2,dp);
    }

    private int solve(int i,int j,String word1,String word2,int[][] dp) {
        if (j<0)
            return i+1;

        if (i<0)
            return j+1;

        if (dp[i][j]!=-1)
            return dp[i][j];

        //if matching
        if (word1.charAt(i)==word2.charAt(j))
            return solve(i-1,j-1,word1,word2,dp);

        //insert char
        int insert=1+solve(i,j-1,word1,word2,dp);

        //delete char
        int delete=1+solve(i-1,j,word1,word2,dp);

        //replace char
        int replace=1+solve(i-1,j-1,word1,word2,dp);

        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
}