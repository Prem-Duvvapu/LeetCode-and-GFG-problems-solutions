//optimal
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int maxLen=0;
        int left=0;
        int right=0;
        int zeroesCnt=0;

        while (right<n) {
            if (nums[right]==0)
                zeroesCnt++;

            while (zeroesCnt>k) {
                if (nums[left]==0)
                    zeroesCnt--;
                
                left++;
            }

            int currLen=right-left+1;
            maxLen=Math.max(maxLen,currLen);
            right++;
        }
        
        return maxLen;
    }
}