class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        int res=0;

        for (int i=0;i<n;i++)
            res|=nums[i];
        res<<=(n-1);

        return res;
    }
}