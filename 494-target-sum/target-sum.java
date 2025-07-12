class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(0,target,nums);
    }

    private int solve(int pos,int target,int[] nums) {
        if (pos==nums.length && target==0)
            return 1;

        if (pos>=nums.length)
            return 0;

        int add = solve(pos+1,target-nums[pos],nums);
        int subtract = solve(pos+1,target+nums[pos],nums);

        return add + subtract;
    }
}