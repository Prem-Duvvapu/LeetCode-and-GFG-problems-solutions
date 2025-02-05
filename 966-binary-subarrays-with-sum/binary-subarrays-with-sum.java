class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res=solve(nums,goal)-solve(nums,goal-1);
        return res;
    }

    private int solve(int[] nums,int goal) {
        if (goal<0)
            return 0;
            
        int left=0;
        int right=0;
        int cnt=0;
        int sum=0;

        while (right < nums.length) {
            sum+=nums[right];

            while (sum > goal) {
                sum-=nums[left];
                left++;
            }

            cnt+=(right-left+1);
            right++;
        }

        return cnt;
    }
}