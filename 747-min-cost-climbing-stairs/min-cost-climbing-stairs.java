class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(solve(n-1,cost,dp),solve(n-2,cost,dp));
    }

    private int solve(int pos,int[] cost,int[] dp)
    {
        if (pos<0)
            return 0;

        if (pos==0)
            return cost[0];

        if (dp[pos]!=-1)
            return dp[pos];

        int oneStep=cost[pos]+solve(pos-1,cost,dp);
        int twoSteps=cost[pos]+solve(pos-2,cost,dp);

        return dp[pos]=Math.min(oneStep,twoSteps);
    }
}