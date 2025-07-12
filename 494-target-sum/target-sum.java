// min Possible sum = 20 * -1000 = 2 * 1_000_0
// max Possible sum = 20 * 1000 - 2 * 1_000

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][5 * 1_000_0];

        for (int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        return solve(0,target,nums,dp);
    }

    private int solve(int pos,int target,int[] nums,int[][] dp) {
        if (pos==nums.length && target==0)
            return 1;

        if (pos>=nums.length)
            return 0;

        if (dp[pos][target+2*1_000_0]!=-1)
            return dp[pos][target+2*1_000_0];

        int add = solve(pos+1,target-nums[pos],nums,dp);
        int subtract = solve(pos+1,target+nums[pos],nums,dp);

        return dp[pos][target+2*1_000_0] = add + subtract;
    }
}