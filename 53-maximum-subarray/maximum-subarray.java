//maxSum subArray = [nums[start], nums[start+1],....,nums[end]]

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int start = 0;
        int end = 0;
        int currSum = 0;
        int tempStart = 0;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                end = i;
                start = tempStart;
            }

            if (currSum < 0) {
                currSum = 0;
                tempStart = i+1;
            }
        }

        return maxSum;
    }
}