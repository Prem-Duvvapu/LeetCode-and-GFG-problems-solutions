class Solution {
    public long largestPerimeter(int[] nums) {
        int n=nums.length;
        long prefixSum=0;

        Arrays.sort(nums);

        for (int i=0;i<n;i++) 
            prefixSum+=nums[i];

        for (int i=n-1;i>1;i--) {
            prefixSum-=nums[i];
            if (nums[i]<prefixSum)
                return prefixSum+nums[i];
        }

        return -1;
    }
}