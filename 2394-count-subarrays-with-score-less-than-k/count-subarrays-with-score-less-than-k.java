class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long res=0L;
        int left=0;
        int right=0;
        long currSum=0L;

        while (right<n) {
            currSum+=nums[right];

            while (left<=right && currSum*(right-left+1L)>=k) {
                currSum-=nums[left];
                left++;
            }

            res+=(right-left+1L);
            right++;
        }

        return res;
    }
}