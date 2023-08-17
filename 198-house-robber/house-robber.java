//Memoization

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
    }

    private int solve(int pos,int[] nums,int[] dp)
    {
        if (pos==0)
            return nums[0];

        if (pos==1)
            return Math.max(nums[1],nums[0]);

        if (dp[pos]!=-1)
            return dp[pos];

        int pick=nums[pos]+solve(pos-2,nums,dp);
        int notPick=solve(pos-1,nums,dp);

        return dp[pos]=Math.max(pick,notPick);
    }
}

//TC:- O(n)
//SC:- O(n)+O(n)