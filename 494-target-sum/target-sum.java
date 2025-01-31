class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return solve(n-1,nums,target);
    }

    private int solve(int pos,int[] nums,int target) {
        if (pos<0) {
            if (target==0)
                return 1;
            return 0;
        }

        int add=nums[pos]+solve(pos-1,nums,target-nums[pos]);
        int sub=-1*nums[pos]+solve(pos-1,nums,target+nums[pos]);

        int res=add+sub;

        return res;
    }
}