class Solution {
    private boolean isValid(int diff,int p,int[] nums)
    {
        int cnt=0;

        for (int i=0;i<nums.length-1;i++)
        {
            if ((nums[i+1]-nums[i])<=diff)
            {
                cnt++;
                i++;
            }
        }

        return (cnt>=p);
    }

    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        Arrays.sort(nums);
        int left=0;
        int right=nums[n-1]-nums[0];
        int result=0;

        //binary search
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            if (isValid(mid,p,nums))
            {
                result=mid;
                right=mid-1;
            }
            else
                left=mid+1;
        }

        return result;
    }
}