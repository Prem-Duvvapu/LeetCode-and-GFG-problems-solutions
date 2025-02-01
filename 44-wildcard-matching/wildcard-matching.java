class Solution {
    public boolean isMatch(String s, String p) {
        int n=p.length();
        int m=s.length();
        int[][] dp=new int[n][m];

        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                dp[i][j]=-1;

        int res=solve(n-1,m-1,p,s,dp);
        if (res==1)
            return true;

        return false;
    }

    private int solve(int i,int j,String s1,String s2,int[][] dp) {
        if (i<0 && j<0)
            return 1;

        if (i<0 && j>=0)
            return 0;

        if (j<0 && i>=0) {
            for (int k=i;k>=0;k--)
                if (s1.charAt(k)!='*')
                    return 0;

            return 1;
        }

        if (dp[i][j]!=-1)
            return dp[i][j];

        if ((s1.charAt(i)=='?') || s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=solve(i-1,j-1,s1,s2,dp);
        else if (s1.charAt(i)=='*')
            return dp[i][j]=(solve(i-1,j,s1,s2,dp) | solve(i,j-1,s1,s2,dp));

        return dp[i][j]=0;
    }
}