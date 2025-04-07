class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;

        Boolean[][] dp=new Boolean[n][20001];

        for (int i=0;i<n;i++)
            totalSum+=nums[i];

        if (totalSum%2==1)
            return false;

        int halfSum=totalSum/2;

        return solve(0,halfSum,dp,nums,n);
    }

    public boolean solve(int pos,int target,Boolean[][] dp,int[] nums,int n) {
        if (target==0)
            return true;

        if (target<0 || pos==n)
            return false;

        if (dp[pos][target]!=null)
            return dp[pos][target];

       boolean pick=solve(pos+1,target-nums[pos],dp,nums,n);
        if (pick)
            return dp[pos][target]=pick;

        boolean notPick=solve(pos+1,target,dp,nums,n);

        return dp[pos][target]=notPick;
    }
}