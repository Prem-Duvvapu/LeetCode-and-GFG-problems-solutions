class Solution {
    public long putMarbles(int[] weights, int k) {
        long res=0;
        int n=weights.length;
        int[] pairs=new int[n-1];

        for (int i=0;i<n-1;i++)
            pairs[i]=weights[i]+weights[i+1];

        Arrays.sort(pairs);
        long minSum=0;
        long maxSum=0;

        for (int i=0;i<k-1;i++)
        {
            minSum+=pairs[i];   //from first
            maxSum+=pairs[n-2-i];   //from Last;
        }

        res=maxSum-minSum;
        return res;
    }
}