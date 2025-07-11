class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int val: nums)
            totalSum += val;

        if ((totalSum&1)==1)
            return false;

        int target = totalSum>>1;
        Boolean[][] dp = new Boolean[n][target+1];

        return solve(0,target,nums,dp);
    }

    private boolean solve(int pos,int target,int[] nums,Boolean[][] dp) {
        if (target==0)
            return true;

        if (pos>=nums.length || target<0)
            return false;

        if (dp[pos][target]!=null)
            return dp[pos][target];

        boolean notPick = solve(pos+1,target,nums,dp);
        boolean pick = solve(pos+1,target-nums[pos],nums,dp);

        return dp[pos][target] = (notPick || pick);
    }
}