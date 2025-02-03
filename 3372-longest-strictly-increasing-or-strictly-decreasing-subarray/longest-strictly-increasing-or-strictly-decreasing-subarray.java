class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int res=1;
        int curr=1;

        //strictly increasing subarry
        for (int i=1;i<n;i++) {
            if (nums[i]>nums[i-1])
                curr++;
            else
                curr=1;

            res=Math.max(res,curr);
        }

        curr=1;
        //strictly increasing subarry
        for (int i=1;i<n;i++) {
            if (nums[i]<nums[i-1])
                curr++;
            else
                curr=1;

            res=Math.max(res,curr);
        }

        return res;
    }
}