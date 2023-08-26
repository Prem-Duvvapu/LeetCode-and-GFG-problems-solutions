class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,new Comparator<int[]>()
        {
            public int compare(int[] a,int[] b)
            {
                if (a[0]!=b[0])
                {
                    if (a[0]>b[0])
                        return 1;
                    else
                        return -1;
                }
                else
                {
                    if (a[1]>b[1])
                        return 1;
                    else
                        return -1;
                }
            }
        });

        int n=pairs.length;
        int[][] dp=new int[n][2002];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        return solve(n-1,1001,pairs,dp);
    }

    private int solve(int pos,int last,int[][] pairs,int[][] dp)
    {
        if (pos==0)
        {
            if (pairs[0][1]<last)
                return 1;
            else
                return 0;
        }
        
        if (dp[pos][last+1000]!=-1)
            return dp[pos][last+1000];

        int notPick=0;
        int pick=0;

        notPick=solve(pos-1,last,pairs,dp);
        if (pairs[pos][1]<last)
            pick=1+solve(pos-1,pairs[pos][0],pairs,dp);

        return dp[pos][last+1000]=Math.max(pick,notPick);
    }
}