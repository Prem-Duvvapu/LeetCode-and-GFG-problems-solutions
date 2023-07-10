class Solution {
    private int firstPartition(int[] arr,int k,int index,int[] dp)
    {
        if (index==arr.length)
            return 0;

        if (dp[index]!=-1)
            return dp[index];

        int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;

        for (int i=index;i<Math.min(index+k,arr.length);i++)
        {
            len++;
            maxi=Math.max(arr[i],maxi);
            int sum=maxi*len+firstPartition(arr,k,i+1,dp);
            maxAns=Math.max(sum,maxAns);
        }

        return dp[index]=maxAns;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return firstPartition(arr,k,0,dp);
    }
}