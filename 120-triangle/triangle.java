class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1;

        return solve(0,0,triangle,dp);
    }

    private int solve(int r,int c,List<List<Integer>> triangle,int[][] dp) {
        if (r==triangle.size())
            return 0;

        if (dp[r][c]!=-1)
            return dp[r][c];

        int below = solve(r+1,c,triangle,dp);
        int diagonal = solve(r+1,c+1,triangle,dp);

        return dp[r][c]=triangle.get(r).get(c) + Math.min(below,diagonal);
    }
}