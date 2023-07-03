class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res=0;
        int val=0;

        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]>threshold)
                val=0;
            else if (val>0 && nums[i-1]%2!=nums[i]%2)
                val++;
            else
                val=1-(nums[i]&1);

            res=Math.max(val,res);
        }

        return res;
    }
}