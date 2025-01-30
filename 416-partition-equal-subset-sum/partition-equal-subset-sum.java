class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        
        for (int i=0;i<n;i++)
            sum+=nums[i];

        if (sum%2==1)
            return false;

        int[][] dp=new int[n][sum+1];

        for (int i=0;i<n;i++)
            for (int j=0;j<=sum;j++)
                dp[i][j]=-1;


        return solve(0,nums,sum/2,dp);
    }

    private boolean solve(int pos,int[] nums,int target,int[][] dp) {
        if (target==0)
            return true;

        if (pos==nums.length || target<0)
            return false;

        if (dp[pos][target]==1)
            return true;
        else if (dp[pos][target]==0)
            return false;

        boolean pick=solve(pos+1,nums,target-nums[pos],dp);
        boolean notPick=solve(pos+1,nums,target,dp);

        boolean res=(pick || notPick);

        if (res)
            dp[pos][target]=1;
        else
            dp[pos][target]=0;

        return res;
    }
}