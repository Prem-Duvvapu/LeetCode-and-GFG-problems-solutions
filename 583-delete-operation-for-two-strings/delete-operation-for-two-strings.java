class Solution {
    String s1;
    String s2;
    int[][] dp;

    public int solve(int i,int j)
    {
        if (dp[i][j]!=-1)
            return dp[i][j];

        if (i==s1.length())
            return dp[i][j]=s2.length()-j;

        if (j==s2.length())
            return dp[i][j]=s1.length()-i;

        if (dp[i][j]!=-1)
            return dp[i][j];

        if (s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=solve(i+1,j+1);

        int delete_char_i=1+solve(i+1,j);
        int delete_char_j=1+solve(i,j+1);

        return dp[i][j]=Math.min(delete_char_i,delete_char_j);
    }

    public int minDistance(String word1, String word2) {
        s1=word1;
        s2=word2;
        dp=new int[s1.length()+1][s2.length()+1];
        for (int i=0;i<=s1.length();i++)
            for (int j=0;j<=s2.length();j++)
                dp[i][j]=-1;
        return solve(0,0);
    }
}