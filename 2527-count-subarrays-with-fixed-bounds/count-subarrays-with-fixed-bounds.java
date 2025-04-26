class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        long res=0;
        int left=0;
        int right=0;
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;
        int minKmaxIndex=-1;
        int maxKmaxIndex=-1;
        
        while (right<n) {
            if (nums[right]<minK || nums[right]>maxK) {
                right++;
                left=right;

                minVal=Integer.MAX_VALUE;
                maxVal=Integer.MIN_VALUE;
                
                minKmaxIndex=-1;
                maxKmaxIndex=-1;

                continue;
            }

            if (nums[right]==minK)
                minKmaxIndex=right;

            if (nums[right]==maxK)
                maxKmaxIndex=right;

            if (minKmaxIndex!=-1 && maxKmaxIndex!=-1)
                res=res+Math.min(minKmaxIndex,maxKmaxIndex)-left+1;

            right++;
        }

        return res;
    }
}