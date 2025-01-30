class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];

        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                for (int k=0;k<m;k++)
                    dp[i][j][k]=-1;

        return solve(0,0,m-1,grid,n,m,dp);
    }

    private int solve(int r,int c1,int c2,int[][] grid,int n,int m,int[][][] dp) {
        if (c1<0 || c2<0 || c1==m || c2==m)
            return 0;

        if (r==n)
            return 0;

        if (dp[r][c1][c2]!=-1)
            return dp[r][c1][c2];

        int res=0;
        for (int i=-1;i<=1;i++) {
            for (int j=-1;j<=1;j++) {
                int curr=grid[r][c1]+grid[r][c2];
                if (c1==c2)
                    curr=grid[r][c1];
                int currMax=curr+solve(r+1,c1+i,c2+j,grid,n,m,dp);
                res=Math.max(res,currMax);
            }
        }

        return dp[r][c1][c2]=res;
    }
}