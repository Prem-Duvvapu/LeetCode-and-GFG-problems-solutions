class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        long total=0L;

        for (int i=0;i<n;i++)
            total+=candies[i];

        if (total<k)
            return 0;

        int low=1;
        int high=1;
        int maxCandies=1;

        for (int i=0;i<n;i++)
            high=Math.max(high,candies[i]);

        while (low<=high) {
            int mid=low+(high-low)/2;
            if (isPossible(candies,k,mid)) {
                maxCandies=mid;
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return maxCandies;
    }

    public boolean isPossible(int[] candies,long k,int mid) {
        long piles=0;

        for (int i=0;i<candies.length;i++) {
            piles+=((long)candies[i]/mid);
        }

        return (piles>=k);
    }
}