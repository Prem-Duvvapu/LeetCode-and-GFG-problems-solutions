//Memoization
//TC: O(n^2)
class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }

    private int solve(int n,int[] dp)
    {
        if (n==1)
            return 1;

        if (dp[n]!=-1)
            return dp[n];

        int maxVal=1*(n-1);

        for (int i=1;i<n;i++)
        {
            int curr=i*Math.max(n-i,solve(n-i,dp));
            maxVal=Math.max(maxVal,curr);
        }

        return dp[n]=maxVal;
    }
}