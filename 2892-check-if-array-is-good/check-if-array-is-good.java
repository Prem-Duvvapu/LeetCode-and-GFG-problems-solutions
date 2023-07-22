class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        if (n==1)
            return false;
        Arrays.sort(nums);
        
        if (n==2 && (nums[0]!=1 || nums[1]!=1))
            return false;
            
        for (int i=0;i<n;i++)
        {
            if (i<n-2 && nums[i]!=i+1)
                return false;
            else if ((i==n-1 || i==n-2) && (nums[i]!=n-1))
                return false;
        }
        return true;
    }
}