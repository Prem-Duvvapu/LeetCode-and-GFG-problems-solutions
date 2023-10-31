class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n=nums.length;
        int maxVal=nums[0];
        long[] res=new long[n];

        res[0]=nums[0]+maxVal;
        for (int i=1;i<n;i++)
        {
            maxVal=Math.max(maxVal,nums[i]);
            res[i]=nums[i]+maxVal+res[i-1];
        }

        return res;
    }
}