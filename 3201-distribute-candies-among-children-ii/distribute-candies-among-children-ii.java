class Solution {
    public long distributeCandies(int n, int limit) {
        long ans=0;
        int amin=Math.max(0,n-2*limit);
        int amax=Math.min(limit,n);

        for (int a=amin;a<=amax;a++)
        {
            int bmin=Math.max(0,n-a-limit);
            int bmax=Math.min(limit,n-a);
            int diff=bmax-bmin+1;
            if (diff>0)
                ans+=diff;
        }

        return ans;
    }
}

//Math.max(0,n-2*limit) <= a <= Math.min(limit,n)
//Math.max(0,n-a-limit) <= a <= Math.min(limit,n-a);