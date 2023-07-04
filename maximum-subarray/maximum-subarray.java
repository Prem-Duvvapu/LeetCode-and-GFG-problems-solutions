class Solution {
    public int maxSubArray(int[] nums) {
        int res=Integer.MIN_VALUE;
        int currSum=0;

        for (int val: nums)
        {
            currSum+=val;
            res=Math.max(currSum,res);
            currSum=Math.max(0,currSum);
        }

        return res;
    }
}