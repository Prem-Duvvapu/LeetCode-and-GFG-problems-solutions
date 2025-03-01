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

            if (isPossible(mid,piles,h)) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return (int)res;
    }

    public boolean isPossible(long k,int[] piles,int h) {
        long cnt=0;

        for (int i=0;i<piles.length;i++) {
            cnt += (piles[i]/k);
            if (piles[i]%k!=0)
                cnt+=1;
        }

        return (cnt<=(long)h);
    }
}

