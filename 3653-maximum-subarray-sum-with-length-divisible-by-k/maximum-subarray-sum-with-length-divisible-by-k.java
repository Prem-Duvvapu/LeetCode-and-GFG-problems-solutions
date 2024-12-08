class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long[] prefixSum = new long[n+1];
        long maxSum = Long.MIN_VALUE;
        long[] minRemSum = new long[k];

        for (int i=1;i<=n;i++)
            prefixSum[i] = prefixSum[i-1]+nums[i-1];

        Arrays.fill(minRemSum, Long.MAX_VALUE);

        for (int i=0;i<=n;i++) {
            int rem = i%k;

            if (i>=k) {
                maxSum=Math.max(maxSum,prefixSum[i]-minRemSum[rem]);
            }

            minRemSum[rem]=Math.min(minRemSum[rem],prefixSum[i]);
        }

        return maxSum;
    }
}