//Better
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int longest=0;
        int curr=1;

        if (n==1)
            return n;

        Arrays.sort(nums);

        for (int i=0;i<n-1;i++) {
            if (nums[i]+1==nums[i+1])
                curr++;
            else if (nums[i]!=nums[i+1])
                curr=1;
            longest=Math.max(longest,curr);
        }

        return longest;
    }
}