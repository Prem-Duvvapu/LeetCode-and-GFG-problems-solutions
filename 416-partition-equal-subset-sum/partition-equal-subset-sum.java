class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        
        for (int i=0;i<n;i++)
            sum+=nums[i];

        if (sum%2==1)
            return false;

        int target=sum/2;
        int[][] dp=new int[n][target+1];

        for (int i=0;i<n;i++)
            for (int j=0;j<=target;j++)
                dp[i][j]=-1;


        return solve(n-1,nums,target,dp);
    }

    private boolean solve(int pos,int[] nums,int target,int[][] dp) {
        if (pos==0)
            return (nums[pos]==target);

        if (dp[pos][target]==1)
            return true;
        else if (dp[pos][target]==0)
            return false;

        boolean notPick=solve(pos-1,nums,target,dp);
        boolean pick=false;
        if (target-nums[pos]>=0)
            pick=solve(pos-1,nums,target-nums[pos],dp);

        boolean res=(pick || notPick);

        if (res)
            dp[pos][target]=1;
        else
            dp[pos][target]=0;

        return res;
    }
}