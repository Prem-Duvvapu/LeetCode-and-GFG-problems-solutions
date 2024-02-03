//Memoization
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,arr,k,n,dp);
    }

    private int solve(int pos,int[] arr,int k,int n,int[] dp)
    {
        if (pos==n)
            return 0;

        if (dp[pos]!=-1)
            return dp[pos];

        int maxSum=Integer.MIN_VALUE;
        int maxVal=Integer.MIN_VALUE;

        for (int i=pos;i<Math.min(pos+k,n);i++)
        {
            maxVal=Math.max(maxVal,arr[i]);
            int len=i-pos+1;
            int currSum=len*maxVal+solve(i+1,arr,k,n,dp);
            maxSum=Math.max(maxSum,currSum);
        }

        return dp[pos]=maxSum;
    }
}