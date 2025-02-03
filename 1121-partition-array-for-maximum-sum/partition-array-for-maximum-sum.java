class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,arr,k,dp);
    }

    private int solve(int pos,int[] arr,int k,int[] dp) {
        if (pos==arr.length)
            return 0;

        if (dp[pos]!=-1)
            return dp[pos];

        int len=0;
        int maxi=0;
        int maxSum=0;
        for (int i=pos;i<Math.min(arr.length,pos+k);i++) {
            maxi=Math.max(maxi,arr[i]);
            len++;

            int currSum=(len*maxi)+solve(i+1,arr,k,dp);
            maxSum=Math.max(maxSum,currSum);
        }

        return dp[pos]=maxSum;
    }
}