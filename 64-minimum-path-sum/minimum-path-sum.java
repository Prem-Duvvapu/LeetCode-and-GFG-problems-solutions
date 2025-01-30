class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1;

        return solve(m-1,n-1,grid,dp);
    }

    private int solve(int r,int c,int[][] grid,int[][] dp) {
        if (r<0 || c<0)
            return (int)1e8;

        if (r==0 && c==0)
            return grid[r][c];

        if (dp[r][c]!=-1)
            return dp[r][c];
            
        int up=solve(r-1,c,grid,dp);
        int left=solve(r,c-1,grid,dp);

        return dp[r][c]=grid[r][c]+Math.min(up,left);
    }
}