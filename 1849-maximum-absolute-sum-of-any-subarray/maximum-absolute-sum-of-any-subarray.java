class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int maxSum=0;
        int currSum=0;

        //kadane's algorithm to calculate maximum positive sum
        for (int i=0;i<n;i++) {
            currSum+=nums[i];
            maxSum=Math.max(maxSum,currSum);
            currSum=Math.max(currSum,0);
        }

        //kadane's algorithm to calculate maximum negative sum
        currSum=0;
        for (int i=0;i<n;i++) {
            currSum+=nums[i];
            maxSum=Math.max(maxSum,Math.abs(currSum));
            currSum=Math.min(currSum,0);
        }

        return maxSum;
    }
}