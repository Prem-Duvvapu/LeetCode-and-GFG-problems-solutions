class Solution {
    private int solve(int pos,int[] nums,int target,int[][] dp)
    {
        if (pos==nums.length)
        {
            if (target==0)
                return 1;
            else
                return 0;
        }

        if (dp[pos][target+1000]!=-1)
            return dp[pos][target+1000];

        int plus=solve(pos+1,nums,target-nums[pos],dp);
        int minus=solve(pos+1,nums,target+nums[pos],dp);
        
        return dp[pos][target+1000]=plus+minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int[][] dp=new int[n][3001];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return solve(0,nums,target,dp);
    }
}