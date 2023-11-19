class Solution {
    public int reductionOperations(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int k=0;
        int res=0;

        for (int i=1;i<n;i++)
        {
            if (nums[i]>nums[i-1])
                k++;

            res+=k;
        }

        return res;
    }
}