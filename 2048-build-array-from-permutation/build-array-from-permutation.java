class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        
        for (int i=0;i<n;i++)
            nums[i]=nums[i]+(nums[nums[i]]%1000)*1000;

        for (int i=0;i<n;i++)
            nums[i]/=1000;

        return nums;
    }
}