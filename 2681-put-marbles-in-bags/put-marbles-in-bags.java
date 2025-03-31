class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;

        if (n==1 || k==1 || n==k)
            return 0L;

        int[] pairSum=new int[n-1];
        long res=0L;

        for (int i=0;i<n-1;i++)
            pairSum[i]=weights[i]+weights[i+1];
        
        Arrays.sort(pairSum);

        for (int i=0;i<k-1;i++) {
            res+=pairSum[n-2-i];
            res-=pairSum[i];
        }

        return res;
    }
}