class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long maxTripletVal=0;
        long maxDiff=(nums[0]-nums[1]);
        long maxi=Math.max(nums[0],nums[1]);

        for (int k=2;k<n;k++) {
            long currVal=maxDiff*nums[k];
            maxTripletVal=Math.max(maxTripletVal,currVal);

            maxDiff=Math.max(maxDiff,maxi-nums[k]);
            maxi=Math.max(maxi,nums[k]);
        }

        return maxTripletVal;
    }
}