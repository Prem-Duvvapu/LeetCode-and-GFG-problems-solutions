class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxVal=0;

        for (int i=0;i<n;i++) {
            if (maxVal<i)
                return false;

            maxVal=Math.max(maxVal,i+nums[i]);
        }

        return true;
    }
}