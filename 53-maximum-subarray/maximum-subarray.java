//Print the subarray which gives the maximum sum
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxSum=(int)-1e5;
        int currSum=0;
        int startIndex=0;
        int endIndex=-1;

        for (int i=0;i<n;i++) {
            if (currSum<0) {
                currSum=0;
                startIndex=i;
            }

            currSum+=nums[i];

            if (currSum>maxSum) {
                maxSum=currSum;
                endIndex=i;
            }
        }

        for (int i=startIndex;i<=endIndex;i++)
            System.out.print(nums[i]+" ");

        return maxSum;
    }
}