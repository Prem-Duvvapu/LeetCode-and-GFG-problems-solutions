class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0] = 1;

        for (int i=1;i<=n;i++) {
            int oneStep = dp[i-1];
            int twoSteps = 0;

            if (i>1)
                twoSteps=dp[i-2];
            dp[i]=oneStep + twoSteps;
        }
        
        return dp[n];
    }
}