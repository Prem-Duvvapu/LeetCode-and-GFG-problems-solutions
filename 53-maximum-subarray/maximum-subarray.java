class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int val: nums) {
            currSum += val;

            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(currSum, 0);
        }

        return maxSum;
    }
}