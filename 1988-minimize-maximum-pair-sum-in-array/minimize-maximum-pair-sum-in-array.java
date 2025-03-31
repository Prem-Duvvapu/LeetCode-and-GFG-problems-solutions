class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        int minMaxPairSum=0;

        Arrays.sort(nums);

        for (int i=0;i<n/2;i++) {
            int currPairSum=nums[i]+nums[n-1-i];
            minMaxPairSum=Math.max(minMaxPairSum,currPairSum);
        }

        return minMaxPairSum;
    }
}