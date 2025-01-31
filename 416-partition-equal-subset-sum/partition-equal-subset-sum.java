//tabulation
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

        if (nums[0]<=target)
                dp[0][nums[0]]=true;

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
}