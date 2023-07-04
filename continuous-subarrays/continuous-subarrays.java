class Solution {
    public long continuousSubarrays(int[] nums) {
        long res=1;
        int minVal=nums[0]-2;
        int maxVal=nums[0]+2;
        int j=0;

        for (int i=1;i<nums.length;i++)
        {
                if (nums[i]>=minVal && nums[i]<=maxVal)
                {
                        minVal=Math.max(nums[i]-2,minVal);
                        maxVal=Math.min(nums[i]+2,maxVal);
                }
                else
                {
                        j=i-1;
                        minVal=nums[i]-2;
                        maxVal=nums[i]+2;

                        while (nums[j]>=minVal && nums[j]<=maxVal)
                        {
                                minVal=Math.max(nums[j]-2,minVal);
                                maxVal=Math.min(nums[j]+2,maxVal);
                                j--;
                        }

                        j++;
                }

                res+=(i-j+1);
        }

        return res;
    }
}