class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int a=solve(nums,goal);
        int b=solve(nums,goal-1);

        return (a-b);
    }

    public int solve(int[] nums,int k) {
        if (k<0)
            return 0;

        int n=nums.length;
        int left=0;
        int right=0;
        int currSum=0;
        int cnt=0;

        while (right<n) {
            currSum+=nums[right];

            //greater than k
            while (left<=right && currSum>k) {
                currSum-=nums[left];
                left++;
            }

            //less than or equal to k
            int currCnt=(right-left)+1;
            cnt+=currCnt;

            right++;
        }

        return cnt;
    }
}