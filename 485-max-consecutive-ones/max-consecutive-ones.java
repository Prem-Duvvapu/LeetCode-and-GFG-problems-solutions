class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int maxConsecutive=0;
        int currConsecutive=0;

        for (int i=0;i<n;i++) {
            if (nums[i]==1) {
                currConsecutive++;
            } else {
                maxConsecutive=Math.max(maxConsecutive, currConsecutive);
                currConsecutive=0;
            }
        }

        maxConsecutive=Math.max(maxConsecutive, currConsecutive);
        return maxConsecutive;
    }
}