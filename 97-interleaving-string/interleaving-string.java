//Memoization

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][][] dp=new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for (int i=0;i<=s1.length();i++)
            for (int j=0;j<=s2.length();j++)
                for (int k=0;k<s3.length();k++)
                    dp[i][j][k]=-1;
        return solve(0,0,0,s1,s2,s3,dp);
    }

    private boolean solve(int i,int j,int k,String s1,String s2,String s3,int[][][] dp)
    {
        if (k==s3.length() && i==s1.length() && j==s2.length())
            return true;

        if (dp[i][j][k]!=-1)
            return (dp[i][j][k]==1);

        boolean b1=false;
        boolean b2=false;

        if (i<s1.length() && s1.charAt(i)==s3.charAt(k))
            b1=solve(i+1,j,k+1,s1,s2,s3,dp);

        if (b1)
            return b1;

        if (j<s2.length() && s2.charAt(j)==s3.charAt(k))
            b2=solve(i,j+1,k+1,s1,s2,s3,dp);

        if (b1 || b2)
            dp[i][j][k]=1;
        else
            dp[i][j][k]=0;
        
        return (b1 || b2);
    }
}