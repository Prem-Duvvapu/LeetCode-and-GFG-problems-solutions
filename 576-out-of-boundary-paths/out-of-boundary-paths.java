class Solution {
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp=new int[m][n][maxMove+1];
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                for (int k=0;k<maxMove+1;k++)
                    dp[i][j][k]=-1;
        return solve(startRow,startColumn,maxMove,m,n,dp);
    }

    private int solve(int i,int j,int x,int m,int n,int[][][] dp) {
        if (i<0 || i==m || j<0 || j==n)
            return 1;

        if (x==0)
            return 0;

        if (dp[i][j][x]!=-1)
            return dp[i][j][x];

        int top=solve(i-1,j,x-1,m,n,dp)%mod;
        int bottom=solve(i+1,j,x-1,m,n,dp)%mod;
        int left=solve(i,j-1,x-1,m,n,dp)%mod;
        int right=solve(i,j+1,x-1,m,n,dp)%mod;

        return dp[i][j][x]=((top+bottom)%mod+(left+right)%mod)%mod;
    }
}