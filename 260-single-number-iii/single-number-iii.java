class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int a=nums[n-1];
        int b=nums[n-1];
        System.out.println(Arrays.toString(nums));

        for (int i=0;i<n-1;i++)
        {
            if (nums[i]==nums[i+1])
                i++;
            else
            {
                if (a==b)
                    a=nums[i];
                else
                {
                    b=nums[i];
                    break;
                }
            }
        }

        return new int[]{a,b};
    }
}