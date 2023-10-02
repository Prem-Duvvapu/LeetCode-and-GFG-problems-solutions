//Tabulation
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        
        for (int pos=n-1;pos>=0;pos--)
        {
            int maxSum=Integer.MIN_VALUE;
            int maxVal=Integer.MIN_VALUE;

            for (int i=pos;i<Math.min(pos+k,n);i++)
            {
                maxVal=Math.max(maxVal,arr[i]);
                int len=i-pos+1;
                int currSum=len*maxVal+dp[i+1];
                maxSum=Math.max(maxSum,currSum);
            }

            dp[pos]=maxSum;
        }

        return dp[0];
    }
}