class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        
        for (int i=0;i<n;i++)
            sum+=nums[i];

        if (sum%2==1)
            return false;

        int target=sum/2;
        boolean[][] dp=new boolean[n][target+1];

        //base cases
        for (int i=0;i<n;i++)
            dp[i][0]=true;

        for (int t=1;t<=target;t++)
            if (nums[0]==t)
                dp[0][t]=true;

        for (int pos=1;pos<n;pos++) {
            for (int t=1;t<=target;t++) {
                boolean notPick=dp[pos-1][t];
                boolean pick=false;
                if (t-nums[pos]>=0)
                    pick=dp[pos-1][t-nums[pos]];

                boolean res=(pick || notPick);

                dp[pos][t]=res;
            }
        }

        return dp[n-1][target];
    }

    private boolean solve(int pos,int[] nums,int target,int[][] dp) {
        if (target==0)
            return true;

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