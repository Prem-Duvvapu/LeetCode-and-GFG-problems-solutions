class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int currIndex=0;
        int res=0;

        while (currIndex<n) {
            while (currIndex<n && nums[currIndex]!=1)
                currIndex++;

            if (currIndex==n)
                return res;

            int currAns=0;
            while (currIndex<n && nums[currIndex]==1) {
                currAns++;
                currIndex++;
            }

            res=Math.max(res,currAns);
        }

        return res;
    }
}