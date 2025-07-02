class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;

        if (n <= 1)
            return n;

        Arrays.sort(nums);
        int maxConsecutive = 1;
        int currConsecutive = 1;

        for (int i=1;i<n;i++) {
            if (nums[i] == nums[i-1]+1)
                currConsecutive++;
            else if (nums[i] == nums[i-1])
                continue;
            else
                currConsecutive = 1;

            maxConsecutive = Math.max(maxConsecutive, currConsecutive);
        }

        return maxConsecutive;
    }
}