class Solution {
    int[] dp=new int[46];
    
    Solution()
    {
        Arrays.fill(dp,-1);
    }

    public int climbStairs(int n) {
        if (n==0 || n==1)
            return 1;

        if (dp[n]!=-1)
            return dp[n];

        int oneStep=climbStairs(n-1);
        int twoSteps=climbStairs(n-2);

        return dp[n]=oneStep+twoSteps;
    }
}