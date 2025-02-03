class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int res=1;
        int maxIncreasing=1;
        int maxDecreasing=1;

        for (int i=1;i<n;i++) {
            if (nums[i]>nums[i-1]) {
                maxIncreasing++;
                maxDecreasing=1;
            } else if (nums[i]<nums[i-1]) {
                maxDecreasing++;
                maxIncreasing=1;
            } else {
                maxIncreasing=1;
                maxDecreasing=1;
            }

            res=Math.max(res,Math.max(maxIncreasing,maxDecreasing));
        }

        return res;
    }
}