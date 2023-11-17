class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int maxVal=Integer.MIN_VALUE;

        for (int i=0;i<n/2;i++)
            maxVal=Math.max(maxVal,nums[i]+nums[n-i-1]);

        return maxVal;
    }
}