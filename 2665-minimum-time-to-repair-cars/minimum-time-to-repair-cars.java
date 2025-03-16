class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n=ranks.length;

        if (n==1)
            return (long)ranks[0]*cars*cars;
            
        long res=0L;
        long low=1;
        long high=1;

        Arrays.sort(ranks);

        high=ranks[n-1];

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
            curr=squareRoot(curr);
            cnt+=curr;
        }

        return (cnt>=cars);
    }

    public long squareRoot(long num) {
        long low=1L;
        long high=num;
        long res=1L;

        while (low<=high) {
            long mid=low+(high-low)/2;
            if (mid*mid<=num) {
                res=mid;
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return res;
    }
}