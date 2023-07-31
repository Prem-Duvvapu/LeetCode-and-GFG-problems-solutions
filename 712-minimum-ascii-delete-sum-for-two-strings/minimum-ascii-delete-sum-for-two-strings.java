class Solution {
    public int solve(String s1,String s2,int i,int j,int[][] dp)
    {
        if (dp[i][j]!=-1)
            return dp[i][j];

        if (i==s1.length() && j==s2.length())
            return 0;

        if (i==s1.length())
            return dp[i][j]=(int)s2.charAt(j)+solve(s1,s2,i,j+1,dp);

        if (j==s2.length())
            return dp[i][j]=(int)s1.charAt(i)+solve(s1,s2,i+1,j,dp);

        if (s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=solve(s1,s2,i+1,j+1,dp);

        int delete_char_i=(int)s1.charAt(i)+solve(s1,s2,i+1,j,dp);
        int delete_char_j=(int)s2.charAt(j)+solve(s1,s2,i,j+1,dp);

        return dp[i][j]=Math.min(delete_char_i,delete_char_j);
    }

    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for (int i=0;i<=s1.length();i++)
            for (int j=0;j<=s2.length();j++)
                dp[i][j]=-1;
        return solve(s1,s2,0,0,dp);
    }
}