class Solution {
    private int helper(int[][] events,int n,int pos,int k,int[][] dp)
    {
        if (pos>=n || k==0)
            return 0;

        if (dp[pos][k]!=-1)
            return dp[pos][k];

        int i=pos+1;
        for (;i<n;i++)
            if (events[i][0]>events[pos][1])
                break;

        return dp[pos][k]=Math.max(helper(events,n,pos+1,k,dp),events[pos][2]+helper(events,n,i,k-1,dp));
    }

    public int maxValue(int[][] events, int k) {
        Comparator<int[]> c=new Comparator<>()
        {
            public int compare(int[] a,int[] b)
            {
                if (a[0]>b[0])
                    return 1;
                else
                    return -1;
            }
        };

        int n=events.length;
        int[][] dp=new int[n][k+1];
        for (int[] i: dp)
            Arrays.fill(i,-1);
        Arrays.sort(events,c);
        for (int i=0;i<n;i++)
            System.out.println(Arrays.toString(events[i]));
        return helper(events,n,0,k,dp);
    }
}