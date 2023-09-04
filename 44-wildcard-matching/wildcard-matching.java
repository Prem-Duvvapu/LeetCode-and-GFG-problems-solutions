//Recursion

class Solution {
    public boolean isMatch(String s, String p) {
        int m=p.length();
        int n=s.length();
        Boolean[][] dp=new Boolean[m+1][n+1];
        return solve(m-1,n-1,p,s,dp);
    }

    private boolean solve(int i,int j,String p,String s,Boolean[][] dp)
    {
        if (i<0 && j<0)
            return true;

        if (i<0 && j>=0)
            return false;

        if (j<0 && i>=0)
        {
            for (int k=0;k<=i;k++)
                if (p.charAt(k)!='*')
                    return false;

            return true;
        }

        if (dp[i][j]!=null)
            return dp[i][j];

        if (p.charAt(i)=='?' || p.charAt(i)==s.charAt(j))
            return dp[i][j]=solve(i-1,j-1,p,s,dp);
        else if (p.charAt(i)=='*')
            return dp[i][j]=(solve(i-1,j,p,s,dp) || solve(i,j-1,p,s,dp));

        return dp[i][j]=false;
    }
}