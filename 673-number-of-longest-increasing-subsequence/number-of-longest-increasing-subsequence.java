class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        int maxi=1;
        int ans=0;

        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        for (int i=0;i<n;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (nums[j]<nums[i] && dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    cnt[i]=cnt[j];
                }
                else if (nums[j]<nums[i] && dp[j]+1==dp[i])
                    cnt[i]+=cnt[j];
            }
            maxi=Math.max(maxi,dp[i]);
        }

        for (int i=0;i<n;i++)
            if (dp[i]==maxi)
                ans+=cnt[i];

        return ans;
    }
}