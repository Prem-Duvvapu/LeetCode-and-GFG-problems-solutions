class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,dp);
    }

    private int solve(int n,int[] dp) {
        if (n<0)
            return 1;

        if (dp[n]!=-1)
            return dp[n];

        int oneStep=solve(n-1,dp);
        int twoStep=0;
        if (n>=1)
            twoStep=solve(n-2,dp);

        return dp[n]=oneStep+twoStep;
    }
}