class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        int curr=0;

        for (int i=0;i<n;i++) {
            if (nums[i]==0) {
                maxLen=Math.max(maxLen,curr);
                curr=0;
            } else {
                curr++;
            }
        }

        maxLen=Math.max(maxLen,curr);
        return maxLen;
    }
}