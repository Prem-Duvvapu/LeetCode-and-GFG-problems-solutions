//Memoization

class Solution {
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m][n][n];
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                for (int k=0;k<n;k++)
                    dp[i][j][k]=-1;
        return solve(0,0,n-1,grid,m,n,dp);
    }

    private int solve(int r,int c1,int c2,int[][] grid,int m,int n,int[][][] dp)
    {
        if (c1<0 || c1>=n || c2<0 || c2>=n)
            return -1;

        if (r==m)
            return -1;

        if (dp[r][c1][c2]!=-1)
            return dp[r][c1][c2];

        int res=grid[r][c1];
        if (c1!=c2)
            res+=grid[r][c2];

        int maxVal=0;
        for (int i=-1;i<=1;i++)
            for (int j=-1;j<=1;j++)
                maxVal=Math.max(maxVal,solve(r+1,c1+i,c2+j,grid,m,n,dp));

        res+=maxVal;

        return dp[r][c1][c2]=res;
    }
}