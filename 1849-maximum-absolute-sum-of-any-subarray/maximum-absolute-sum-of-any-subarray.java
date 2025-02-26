class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int maxSum=0;
        int currPositiveSum=0;
        int currNegativeSum=0;

        for (int i=0;i<n;i++) {
            currPositiveSum+=nums[i];
            currNegativeSum+=nums[i];

            maxSum=Math.max(maxSum,currPositiveSum);
            maxSum=Math.max(maxSum,Math.abs(currNegativeSum));

            currPositiveSum=Math.max(currPositiveSum,0);
            currNegativeSum=Math.min(currNegativeSum,0);
        }

        return maxSum;
    }
}