class Solution {
    public int longestSubarray(int[] nums) {
        int res=0;
        int left=0;
        int zeroesCnt=0;

        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]==0)
                zeroesCnt++;

            while (zeroesCnt==2)
            {
                if (nums[left]==0)
                    zeroesCnt=1;
                    
                left++;
            }

            res=Math.max(i-left,res);
        }

        return res;
    }
}