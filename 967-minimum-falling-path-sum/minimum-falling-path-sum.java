class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int res=Integer.MAX_VALUE;
        int[][] dp=new int[n][n];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1000000;

        for (int c=0;c<n;c++)
            for (int i=-1;i<=1;i++)
                res=Math.min(res,matrix[0][c] + solve(1,c+i,n,matrix,dp));

        return res;
    }

    private int solve(int r,int c,int n,int[][] matrix,int[][] dp) {
        if (c<0 || c==n)
            return (int)1e5;

        if (r==n)
            return 0;

        if (dp[r][c]!=-1000000)
            return dp[r][c];

        int res = (int)1e8;
        for (int i=-1;i<=1;i++)
            res = Math.min(res,matrix[r][c]+solve(r+1,c+i,n,matrix,dp));

        return dp[r][c]=res;
    }
}