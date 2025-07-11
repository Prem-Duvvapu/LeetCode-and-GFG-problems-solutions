class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int val: nums)
            totalSum += val;

        if ((totalSum&1)==1)
            return false;

        int reqTarget = totalSum>>1;
        boolean[][] dp = new boolean[n+1][reqTarget+1];

        for (int i=0;i<=n;i++)
            dp[i][0] = true;

        for (int pos=n-1;pos>=0;pos--) {
            for (int target=1;target<=reqTarget;target++) {
                boolean notPick = dp[pos+1][target];

                boolean pick = false;
                if (target>=nums[pos])
                    pick=dp[pos+1][target-nums[pos]];

                dp[pos][target]=(pick || notPick);
            }
        }

        // return solve(0,target,nums,dp);
        return dp[0][reqTarget];
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