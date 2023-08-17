//Space optimization

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==1)
            return nums[0];

        if (n==2)
            return Math.max(nums[1],nums[0]);

        int prev2=nums[0];
        int prev1=Math.max(nums[1],nums[0]);

        for (int i=2;i<n;i++)
        {
            int pick=nums[i]+prev2;
            int notPick=prev1;
            int curr=Math.max(pick,notPick);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}

//TC:- O(n)
//SC:- O(1)