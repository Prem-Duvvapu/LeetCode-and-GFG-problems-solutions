class Solution {
    private int solve(int start,int end,int[][] dp)
    {
        if (start>=end)
            return 1;

        if (dp[start][end]!=-1)
            return dp[start][end];

        int res=0;
        for (int i=start;i<=end;i++)
        {
            int left=solve(start,i-1,dp);
            int right=solve(i+1,end,dp);
            res+=(left*right);
        }

        return dp[start][end]=res;
    }

    public int numTrees(int n) {
        int[][] dp=new int[n+1][n+1];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return solve(1,n,dp);
    }
}