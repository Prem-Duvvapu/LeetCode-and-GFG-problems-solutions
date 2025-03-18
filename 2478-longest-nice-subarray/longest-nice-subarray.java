class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        int maxLength=1;
        int currLength=1;
        int usedBits=0;

        while (right<n) {
            while ((nums[right]&usedBits)!=0) {
                usedBits=(usedBits^nums[left]);
                left++;
            }

            usedBits=(usedBits|nums[right]);
            currLength=right-left+1;
            maxLength=Math.max(maxLength,currLength);

            right++;
        }

        return maxLength;
    }
}