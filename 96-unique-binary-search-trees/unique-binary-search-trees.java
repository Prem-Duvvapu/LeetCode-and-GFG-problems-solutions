class Solution {
    private int solve(int start,int end)
    {
        // if (start>end)
        //     return 0;

        if (start>=end)
            return 1;

        int res=0;

        for (int i=start;i<=end;i++)
        {
            int left=solve(start,i-1);
            int right=solve(i+1,end);
            res=res+left*right;
        }

        return res;
    }

    public int numTrees(int n) {
        return solve(1,n);
    }
}