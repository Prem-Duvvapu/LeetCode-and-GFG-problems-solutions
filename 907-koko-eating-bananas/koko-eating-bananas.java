class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = (int)1e9;
        int res = high;

        while (low <= high) {
            int mid = low + (high - low)/2;
            
            if (isPossible(mid,piles,h)) {
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return res;
    }

    private boolean isPossible(int mid,int[] piles,int h) {
        long hours = 0;

        for (int val: piles) {
            hours += (val/mid);

            if (val%mid != 0)
                hours += 1;
        }

        return (hours <= (long)h);
    }
}