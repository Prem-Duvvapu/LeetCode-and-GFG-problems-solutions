//brute force
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int maxLen=0;

        for (int i=0;i<n;i++) {
            int zeroesCnt=0;
            for (int j=i;j<n;j++) {
                if (nums[j]==0)
                    zeroesCnt++;

                if (zeroesCnt>k)
                    break;

                int currLen=j-i+1;
                maxLen=Math.max(maxLen,currLen);
            }
        }

        return maxLen;
    }
}