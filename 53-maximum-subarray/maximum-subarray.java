//Optimal
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxSum=(int)-1e5;
        int currSum=0;

        for (int i=0;i<n;i++) {
            if (currSum<0)
                currSum=0;

            currSum+=nums[i];
            maxSum=Math.max(maxSum,currSum);
        }

        return maxSum;
    }
}