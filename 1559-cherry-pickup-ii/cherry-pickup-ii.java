class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                Arrays.fill(dp[i][j],-1);

        return solve(0,0,n-1,grid,m,n,dp);
    }

    private int solve(int r1,int c1,int c2,int[][] grid,int m,int n,int[][][] dp) {
        if (c1<0 || c1>=n || c2<0 || c2>=n)
            return -(int)1e5;

        if (r1>=m)
            return 0;

        if (dp[r1][c1][c2]!=-1)
            return dp[r1][c1][c2];

        int curr = grid[r1][c1];
        if (c1!=c2)
            curr += grid[r1][c2];
        int res = 0;

        for (int i=-1;i<=1;i++) {
            for (int j=-1;j<=1;j++) {
                res = Math.max(res,solve(r1+1,c1+i,c2+j,grid,m,n,dp));
            }
        }

        res += curr;

        return dp[r1][c1][c2] = res;
    }
}