class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[n][m];

        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                dp[i][j]=-1;

        return solve(n-1,m-1,s,p,dp);
    }

    private boolean solve(int i,int j,String s,String p,int[][] dp) {
        if (i<0 && j<0)
            return true;

        if (j<0 && i>=0)
            return false;

        if (i<0 && j>=0) {
            for (int k=j;k>=0;k--)
                if (p.charAt(k)!='*')
                    return false;

            return true;
        }
        
        if (i<0) {
            if (j<0)
                return true;
            
            if (j==0 && p.charAt(j)=='*')
                return true;
            
            int k=j;
            for (;k>=0;k--)
                if (p.charAt(j)!='*')
                    return false;

            if (k<0)
                return true;

            return false;
        }
            
        if (j<0)
            return false;

        if (dp[i][j]!=-1) {
            if (dp[i][j]==1)
                return true;
            return false;
        }

        boolean res=false;

        if (p.charAt(j)!='*' && p.charAt(j)!='?') {
            if (p.charAt(j)==s.charAt(i)) {
                res=solve(i-1,j-1,s,p,dp);
                if (res)
                    dp[i][j]=1;
                else
                    dp[i][j]=0;
                return res;
            } else {
                res=false;
                if (res)
                    dp[i][j]=1;
                else
                    dp[i][j]=0;
                return res;
            }
        }

        if (p.charAt(j)=='?') {
            res=solve(i-1,j-1,s,p,dp);
            if (res)
                dp[i][j]=1;
            else
                dp[i][j]=0;
            return res;
        }

        //*
        boolean x=solve(i,j-1,s,p,dp);
        boolean y=solve(i-1,j-1,s,p,dp);
        boolean z=solve(i-1,j,s,p,dp);

        res=(x || y|| z);
        if (res)
            dp[i][j]=1;
        else
            dp[i][j]=0;

        return res;
    }
}