class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==1)
            return nums[0];
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int last=solve(n-1,nums,n-1,dp);
        Arrays.fill(dp,-1);
        int first=solve(n-2,nums,n-2,dp);

        return Math.max(first,last);
    }

    private int solve(int pos,int[] nums,int n,int[] dp)
    {
        if (pos==0)
        {
            if (n==nums.length-1)
                return 0;
            else
                return nums[0];
        }

        if (pos<0)
            return 0;

        if (dp[pos]!=-1)    
            return dp[pos];

        int pick=nums[pos]+solve(pos-2,nums,n,dp);
        int notPick=solve(pos-1,nums,n,dp);

        return dp[pos]=Math.max(pick,notPick);
    }
}