class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n-1,nums,dp);
    }

    private int solve(int pos,int last,int[] nums,int[] dp) {
        if (pos>last)
            return 0;

        if (dp[pos]!=-1)
            return dp[pos];

        int pick=nums[pos]+solve(pos+2,last,nums,dp);
        int notPick=solve(pos+1,last,nums,dp);

        return dp[pos]=Math.max(pick,notPick);
    }
}