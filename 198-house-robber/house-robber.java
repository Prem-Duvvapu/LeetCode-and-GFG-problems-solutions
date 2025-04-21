class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,dp,nums,n);
    }

    public int solve(int pos,int[] dp,int[] nums,int n) {
        if (pos>=n)
            return 0;
        
        if (dp[pos]!=-1)
            return dp[pos];

        int pick=nums[pos]+solve(pos+2,dp,nums,n);
        int notPick=0+solve(pos+1,dp,nums,n);

        return dp[pos]=Math.max(pick,notPick);
    }
}