class Solution {
    public int majorityElement(int[] nums) {
        int res=nums[0];
        int cnt=1;

        for (int i=1;i<nums.length;i++)
        {
            if (nums[i]==res)
                cnt++;
            else if (cnt==0)
            {
                res=nums[i];
                cnt=1;
            }
            else
                cnt--;
        }
        
        return res;
    }
}