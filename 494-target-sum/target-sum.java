class Solution {
    private int solve(int pos,int[] nums,int target)
    {
        if (pos==nums.length)
        {
            if (target==0)
                return 1;
            else
                return 0;
        }

        int plus=solve(pos+1,nums,target-nums[pos]);
        int minus=solve(pos+1,nums,target+nums[pos]);
        return plus+minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(0,nums,target);
    }
}