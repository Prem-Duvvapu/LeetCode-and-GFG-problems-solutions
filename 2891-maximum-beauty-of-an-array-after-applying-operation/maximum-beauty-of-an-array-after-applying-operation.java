class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int res=0;
        Arrays.sort(nums);

        for (int right=0;right<n;right++)
        {
            if (nums[right]-nums[left]>2*k)
                left++;
            else
                res=Math.max(right-left+1,res);
        }

        return res;
    }
}