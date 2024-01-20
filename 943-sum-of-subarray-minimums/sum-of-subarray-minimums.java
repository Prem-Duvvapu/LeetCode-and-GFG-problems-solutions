class Solution {
    public int sumSubarrayMins(int[] arr) {
        long mod=(long)1e9+7;
        int n=arr.length;
        long res=0L;

        for (int i=0;i<n;i++) {
            int left=i;
            int right=i;

            while (left-1>=0) {
                if (arr[left-1]>arr[i])
                    left--;
                else
                    break;
            }

            while (right+1<n) {
                if (arr[right+1]>=arr[i])
                    right++;
                else
                    break;
            }

            long curr=(long)(i-left+1)*(right-i+1)*arr[i];
            res=(res+curr)%mod;
        }

        return (int)res;
    }
}