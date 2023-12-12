class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int res=0;
        for (int i=n-1;i>0;i--)
            res=Math.max(res,(nums[i]-1)*(nums[i-1]-1));

        return res;
    }
}