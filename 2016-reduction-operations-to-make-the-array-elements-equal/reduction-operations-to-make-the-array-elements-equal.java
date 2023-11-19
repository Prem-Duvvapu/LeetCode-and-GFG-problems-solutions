class Solution {
    public int reductionOperations(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int maxVal=nums[0];
        int k=0;
        int res=0;

        for (int i=1;i<n;i++)
        {
            if (nums[i]>maxVal)
            {
                maxVal=nums[i];
                k++;
            }
            res+=k;
        }

        return res;
    }
}