class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }

    private int solve(int pos,int[] dp) {
        if (pos==0)
            return 1;

        if (dp[pos]!=-1)
            return dp[pos];

        int oneStep = solve(pos-1,dp);
        int twoSteps = 0;
        if (pos>1)
            twoSteps = solve(pos-2,dp);

        return dp[pos]=oneStep + twoSteps;
    }
}