//Memoization

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for (int[] arr: dp)//step-1
            Arrays.fill(arr,-1);
        return solve(0,0,triangle,n,dp);
    }

    private int solve(int row,int col,List<List<Integer>> triangle,int n,int[][] dp)
    {
        if (row==n-1)
            return triangle.get(row).get(col);

        if (dp[row][col]!=-1)//step-3
            return dp[row][col];

        int down=solve(row+1,col,triangle,n,dp);
        int diag=solve(row+1,col+1,triangle,n,dp);

        return dp[row][col]=triangle.get(row).get(col)+Math.min(down,diag);//step-2
    }
}