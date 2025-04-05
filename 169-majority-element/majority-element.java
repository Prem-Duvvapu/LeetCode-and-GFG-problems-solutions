class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int res=nums[0];
        int cnt=1;

        for (int i=1;i<n;i++) {
            if (nums[i]==res)
                cnt++;
            else if (cnt==0)
                res=nums[i];
            else
                cnt--;
        }

        return res;
    }
}