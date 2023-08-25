//Memoization

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for (int i=0;i<=s1.length();i++)
            for (int j=0;j<=s2.length();j++)
                    dp[i][j]=-1;
        return solve(0,0,s1,s2,s3,dp);
    }

    private boolean solve(int i,int j,String s1,String s2,String s3,int[][] dp)
    {
        if (i+j==s3.length() && i==s1.length() && j==s2.length())
            return true;

        if (i+j==s3.length())
            return false;

        if (dp[i][j]!=-1)
            return (dp[i][j]==1);

        boolean b1=false;
        boolean b2=false;

        if (i<s1.length() && s1.charAt(i)==s3.charAt(i+j))
            b1=solve(i+1,j,s1,s2,s3,dp);

        if (b1)
            return b1;

        if (j<s2.length() && s2.charAt(j)==s3.charAt(i+j))
            b2=solve(i,j+1,s1,s2,s3,dp);

        if (b1 || b2)
            dp[i][j]=1;
        else
            dp[i][j]=0;
        
        return (b1 || b2);
    }
}