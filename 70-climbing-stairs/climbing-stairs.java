class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }

    private int solve(int pos) {
        if (pos<0)
            return 0;

        if (pos==0)
            return 1;

        if (dp[pos]!=-1)
            return dp[pos];

        int oneStep = solve(pos-1);
        int twoSteps = solve(pos-2);

        return dp[pos]=oneStep + twoSteps;
    }
}