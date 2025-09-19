class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = 1;
        int high = (int)1e9;
        int res = high;

        if ((long)n < (long)m*k)
            return -1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (isPossible(mid,bloomDay,m,k)) {
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return res;
    }

    private boolean isPossible(int mid,int[] bloomDay,int m,int k) {
        int bouquets = 0;
        int flowers = 0;
        
        for (int i=0;i<bloomDay.length;i++) {
            if (bloomDay[i] <= mid) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return (bouquets >= m);
    }
}