class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res=0;
        int product=1;

        for (int i=0,j=0;j<nums.length;j++)
        {
            product*=nums[j];
            
            while (i<=j && product>=k)
                product/=nums[i++];

            res+=(j-i+1);
        }

        return res;
    }
}