class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        long low=1;
        long high=1;

        for (int i=0;i<n;i++)
            high=Math.max(high,piles[i]);

        long res=high;

        while (low<=high) {
            long mid=low+(high-low)/2;

            long curr=0;
            for (int i=0;i<n;i++) {
                curr = curr+piles[i]/mid;
                if (piles[i]%mid!=0)
                    curr+=1;

                if (curr>h) {
                    low=mid+1;
                    continue;
                }
            }

            if (curr<=h) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return (int)res;
    }
}