class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res=0;
        
        for (int l=0;l<nums.length;l++)
        {
            if (nums[l]%2==1 || nums[l]>threshold)
                continue;

            res=Math.max(1,res);
            for (int r=l+1;r<nums.length && nums[r]<=threshold;r++)
            {
                if (nums[r]%2==nums[r-1]%2)
                    break;

                res=Math.max(r-l+1,res);
            }
        }

        return res;
    }
}