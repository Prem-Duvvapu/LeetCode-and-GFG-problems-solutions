class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long maxTripletVal=0;
        long maxDiff=(nums[0]-nums[1]);
        long maxi=Math.max(nums[0],nums[1]);

        for (int k=2;k<n;k++) {
            long currVal=maxDiff*nums[k];

            //current value can be in kth postion in the final triplet
            maxTripletVal=Math.max(maxTripletVal,currVal); 

            //current value can be in jth postion in the final triplet
            maxDiff=Math.max(maxDiff,maxi-nums[k]);

            //current value can be in ith postion in the final triplet
            maxi=Math.max(maxi,nums[k]);
        }

        return maxTripletVal;
    }
}