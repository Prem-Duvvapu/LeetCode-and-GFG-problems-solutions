class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];

        for (int j=0;j<n;j++)
                dp[n-1][j]=triangle.get(n-1).get(j);

        for (int r=n-2;r>=0;r--) {
            for (int c=r;c>=0;c--) {
                int below = dp[r+1][c];
                int diagonal = dp[r+1][c+1];
                dp[r][c]=triangle.get(r).get(c) + Math.min(below,diagonal);
            }
        }

        return dp[0][0];
    }
}