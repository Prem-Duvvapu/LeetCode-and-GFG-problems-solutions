class Solution {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int curr=nums[0];
        int res=curr;

        for (int i=1;i<n;i++) {
            if (nums[i-1]<nums[i])
                curr+=nums[i];
            else
                curr=nums[i];
            
            res=Math.max(res,curr);
        }

        return res;
    }
}