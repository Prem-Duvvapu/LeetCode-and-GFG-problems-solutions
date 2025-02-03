class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int m=n+2;

        int[] arr=new int[m];
        arr[0]=arr[m-1]=1;

        int[][] dp=new int[m][m];

        for (int i=0;i<m;i++)
            for (int j=0;j<m;j++)
                dp[i][j]=-1;

        for (int i=0;i<n;i++)
            arr[i+1]=nums[i];

        return solve(1,m-2,arr,dp);
    }

    private int solve(int left,int right,int[] arr,int[][] dp) {
        if (left>right)
            return 0;

        if (dp[left][right]!=-1)
            return dp[left][right];

        int maxCoins=0;
        for (int i=left;i<=right;i++) {
            int currCoins=arr[left-1]*arr[i]*arr[right+1]+solve(left,i-1,arr,dp)+solve(i+1,right,arr,dp);
            maxCoins=Math.max(maxCoins,currCoins);
        }

        return dp[left][right]=maxCoins;
    }
}