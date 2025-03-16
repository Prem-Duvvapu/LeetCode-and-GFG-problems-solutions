class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n=ranks.length;
        long res=0L;
        long low=1;
        long high=Integer.MAX_VALUE;

        for (int i=0;i<n;i++)
            high=Math.min(high,ranks[i]);

        high=high*cars*cars;
        res=high;

        while (low<=high) {
            long mid=low+(high-low)/2;

            if (isPossible(ranks,cars,mid)) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return res;
    }

    public boolean isPossible(int[] ranks,int cars,long maxTime) {
        long cnt=0;

        for (int i=0;i<ranks.length;i++) {
            if (maxTime<ranks[i])
                continue;
            long curr=maxTime/ranks[i];
            curr=(long)Math.sqrt(curr);
            cnt+=curr;
        }

        return (cnt>=cars);
    }
}